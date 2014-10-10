package com.fountontec.collector.monitor;

import java.nio.charset.Charset;

import org.apache.commons.io.input.TailerListenerAdapter;

import com.fountontec.collector.common.SpringHelper;
import com.fountontec.collector.sender.MessageSenderService;


public class SimpleLogTailerListener extends TailerListenerAdapter{

	@Override
	public void handle(String line) {
		
		final Charset charset = Charset.defaultCharset();//Charset.forName('UTF-8');
		char[] chs = line.toCharArray();
		byte[] data = new byte[chs.length];
		for (int i = 0; i < data.length; i++) {
			data[i] = (byte) chs[i];
		}
		line = new String(data,charset);
		
		((MessageSenderService)SpringHelper.getBean("messageSenderService")).put(line);
    }
}
