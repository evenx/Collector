package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fountontec.collector.common.LogKeys;
import com.fountontec.collector.common.MessageType;

public class CustomizedPiMessage extends CustomizedMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("current_fans_count")
	private long currentFans;
	public long getCurrentFans() {
		return currentFans;
	}
	public void setCurrent_fans_count(long currentFans) {
		this.currentFans = currentFans;
	}
	
	@JsonIgnore
	@Override
	public LogKeys getLogType(){
		return LogKeys.s_pi;
	}
	
	@JsonIgnore
	@Override
	public MessageType getMessageType() {
		return MessageType.pd_init;
	}

}
