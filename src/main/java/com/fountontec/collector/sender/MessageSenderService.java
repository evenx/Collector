package com.fountontec.collector.sender;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.annotation.PreDestroy;
import javax.validation.ValidatorFactory;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fountontec.collector.common.Common;
import com.fountontec.collector.common.MessageType;
import com.fountontec.collector.common.Utils;
import com.fountontec.collector.common.ValidatorUtils;
import com.fountontec.collector.domail.SingleMessage;

/**
 * 
 * @author wenyi
 *
 */
@Component
public class MessageSenderService {

	
	private ExecutorService executeService = Executors.newFixedThreadPool(3);
	//tps*timeout tps = 30000 default
	private BlockingQueue<String> queue;
	private volatile List<SingleMessage> logs;
	
	public void put(String content){
		try {
			queue.put(content);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Scheduled(fixedDelay = 500)
	public void consume(){
		synchronized (logs) {
			if(!logs.isEmpty()){
				try {
					List<SingleMessage> des = Utils.deepCopy(logs);
					executeService.execute(new MessageSender(des));
					logs = null;
					logs = new ArrayList<SingleMessage>();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
		
	}
	
	public void production(){
		
		
		queue = new LinkedBlockingQueue<String>(20000);
		logs = new ArrayList<SingleMessage>();
		//queue take元素
		Thread th = new Thread(new Runnable() {
			public void run() {
				while(true){
					try {
						String me = queue.take();
						JSONObject json = (JSONObject)JSON.parseObject(me).get(Common.LOG_VALUE_KEY);
						MessageType type = MessageType.valueOf((String)json.get(Common.MESSAGE_TYPE_KEY));
						SingleMessage log = JSON.parseObject(json.toString(), type.getType(json));
						ValidatorFactory vf = ValidatorUtils.getFatory();
						if(vf.getValidator().validate(log).size() == 0){
							synchronized (logs) {
								logs.add(log);
							}
						}
						json = null;
						type = null;
					}  catch (Exception e){
						//nothing
					}
				}
					
				}
		},"queue taking");
		th.start();	
	}
	
	@PreDestroy
	public void shutdown(){
		executeService.shutdown();
	}
	
}
