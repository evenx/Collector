package com.fountontec.collector.domail;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fountontec.collector.common.LogKeys;
import com.fountontec.collector.common.MessageType;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public abstract class Message implements SingleMessage, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("MsgType")
	@NotNull
	private String msgType;

	public String getMsgType() {
		return msgType;
	}

	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}

	public abstract LogKeys getLogType();

	public abstract MessageType getMessageType();
	
}
