package com.fountontec.collector.monitor;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fountontec.collector.common.Common;
import com.fountontec.collector.common.Config;

@Component
public class SimpleLogService {

	@Autowired
	private Config config;
	private static SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd_HH");
	private static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void start(){
		
		String currentHourLogName = Common.LOG_FILE_NAME_SIMPLE+simpleDateFormat.format(new Date())+".log";
		String beforeHourLogName = Common.LOG_FILE_NAME_SIMPLE+simpleDateFormat.format(DateUtils.addHours(new Date(), -1))+".log";
		String existLogRename = currentHourLogName + "." + System.currentTimeMillis() +".bak";
		File file = new File(config.getSimpleLogDir() + currentHourLogName);
		boolean restart = false;
		//是否重启
		if(file.exists()){
			try {
				FileUtils.moveFile(file, new File(config.getSimpleLogDir() + existLogRename));
				restart = true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		//目录监控
		FileAlterationObserver fao = new FileAlterationObserver(config.getSimpleLogDir());
		fao.addListener(new DirectoryListener());
		FileAlterationMonitor monitor = new FileAlterationMonitor(1000 ,fao);
		try {
			monitor.start();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		//重新生成当前小时日志文件纳入监控服务,并记录监控日志
		if(restart){
			//must be here, after delete file
			Logger logger = LoggerFactory.getLogger(SimpleLogService.class);
			logger.info("finished----"+format.format(new Date())+"----"+existLogRename);
			File la = new File(config.getSimpleLogDir() + beforeHourLogName);
			if(la.exists()){
				logger.info("finished----"+format.format(new Date())+"----"+beforeHourLogName);
			}
		}
		
	}
	
}
