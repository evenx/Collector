package com.fountontec.collector.server;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.fountontec.collector.common.SpringHelper;
import com.fountontec.collector.monitor.SimpleLogService;
import com.fountontec.collector.sender.MessageSenderService;

/**
 * 
 * @author wenyi
 * spring必须延迟加载对象
 *
 */
@Component
@Lazy(false)
public class PDLaunch {

	
	@Autowired
	private SimpleLogService simpleLogService;
	@Autowired
	private MessageSenderService messageSenderService;
	
	
	@PostConstruct
	public void start(){
		simpleLogService.start();
		messageSenderService.production();
		//simplelogservice will move log file,but server will hold file, so server must be here
		getServer().start();
		
	}
	
	public NettyHttpServer getServer(){
		return (NettyHttpServer)SpringHelper.getBean("nettyHttpServer");
	}
	
	
}
