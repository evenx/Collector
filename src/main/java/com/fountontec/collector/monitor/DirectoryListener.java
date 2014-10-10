package com.fountontec.collector.monitor;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

public class DirectoryListener extends FileAlterationListenerAdaptor{

	@Override
	public void onFileCreate(File file) {
		Thread t = new Thread(new SimpleMonitor(file, new Date()),"file monitor thread kill--"+file.getName());
		t.start();
	}
	
}
