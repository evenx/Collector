package com.fountontec.collector.sender;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fountontec.collector.client.PDHttpClient;
import com.fountontec.collector.common.Common;
import com.fountontec.collector.common.ConfigUtils;
import com.fountontec.collector.common.JacksonUtils;
import com.fountontec.collector.domail.SingleMessage;

public class MessageSender implements Runnable{

	
		private static final Logger logger = LoggerFactory.getLogger(MessageSender.class);
		private List<SingleMessage> list;
		private static final int pack = ConfigUtils.getInstance().getMaxMessages();//最多pack条消息一个发送包
		
		public MessageSender(List<SingleMessage> list){
			this.list = list;
		}
		
		public void run() {

			if(list.isEmpty())
				return;
			//default
			int packed = pack <=100?100:pack;
			int size = list.size();
			int sub = (int)Math.ceil((double)size/packed);
			for(int index = 0; index < sub; index++){
				try {
					int end = (index+1)*packed;
					if(end > size){
						end = size;
					}
					List<SingleMessage> subs = list.subList(index*packed, end);
					Log all = new Log();
					for(SingleMessage log: subs){
						if(log.getMessageType() != null){
							all.getB().addMessage(log);
						}
					}
					String json = JacksonUtils.writeValue(all);
					int status = PDHttpClient.getInstance().post(json, ConfigUtils.getInstance().getAccepterUrl()+Common.ADDRESS_WEXIN);
					if(status != 200){
						logger.info(json);
					}
					
					subs = null;	
				    all = null;
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			//
			list = null;
	}

}
