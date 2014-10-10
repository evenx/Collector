package com.fountontec.collector.sender;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fountontec.collector.client.PDHttpClient;
import com.fountontec.collector.common.Common;
import com.fountontec.collector.common.Config;
import com.fountontec.collector.common.ConfigUtils;

@Component
@Lazy(false)
public class MessageReSender {

	@Autowired
	private Config config;
	
	@Scheduled(cron="${message.resend.schedule}")
	public void reSendMessage(){
		
		String dir = config.getPacketLogDir();
		String date = new SimpleDateFormat("yyyy-MM-dd").format(DateUtils.addDays(new Date(), -1));
		File file = new File(dir+Common.LOG_FILE_NAME_PACK+date+".log");
		if(!file.exists())
		    return;
		BufferedInputStream bis = null;
		BufferedReader reader = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(file));
			reader = new BufferedReader(new InputStreamReader(bis), 5*1024*1024);//5M 
			String line = reader.readLine();
			while(line != null){
				PDHttpClient.getInstance().post(line, ConfigUtils.getInstance().getAccepterUrl()+Common.ADDRESS_WEXIN);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(bis != null){
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(reader != null){
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
			
	}
}
