package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fountontec.collector.common.LogKeys;
import com.fountontec.collector.common.MessageType;

public class SimpleTeMessage extends SimpleMessage{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("Content")
	private String content;
	@JsonProperty("MsgId")
	private long msgID;
	
	@JsonIgnore
	@Override
	public LogKeys getLogType() {
		return LogKeys.s_te;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getMsgID() {
		return msgID;
	}

	public void setMsgID(long msgID) {
		this.msgID = msgID;
	}
	
	@JsonIgnore
	@Override
	public MessageType getMessageType() {
		return MessageType.text;
	}

}
