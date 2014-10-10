package com.fountontec.collector.domail;

import com.fountontec.collector.common.LogKeys;
import com.fountontec.collector.common.MessageType;

public interface SingleMessage{

	
	public LogKeys getLogType();
	public MessageType getMessageType();
}
