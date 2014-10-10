package com.fountontec.collector.monitor;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.input.Tailer;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleMonitor implements Runnable{

	private static final Logger logger = LoggerFactory.getLogger(SimpleMonitor.class);
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private File file;
	private Date created;
	
	public SimpleMonitor(File file, Date created){
		this.created = created;
		this.file = file;
	}
	
	public void run() {
		//日志文件监控
		Tailer tai = new Tailer(file,new SimpleLogTailerListener(),1000);
		Thread th = new Thread(tai,"file monitor--"+file.getName());
		th.start();
		//kill
		logger.info("start----"+simpleDateFormat.format(new Date())+"----"+file.getName());
		while(true){
			try {
				TimeUnit.MINUTES.sleep(10);//十分钟检查一次
				logger.info("monitoring----"+simpleDateFormat.format(new Date())+"----"+file.getName());
				Period p = new Period(created.getTime(), new Date().getTime(), PeriodType.minutes());
				int between = p.getMinutes();
				if(between > 65){//超过65minutes 该日志文件监控取消
					tai.stop();
					logger.info("finished----"+simpleDateFormat.format(new Date())+"----"+file.getName());
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
