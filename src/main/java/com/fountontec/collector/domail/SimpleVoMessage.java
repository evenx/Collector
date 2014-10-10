package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fountontec.collector.common.LogKeys;
import com.fountontec.collector.common.MessageType;

public class SimpleVoMessage extends SimpleMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("MediaId")
	private String mediaID;
	@JsonProperty("Format")
	private String format;
	@JsonProperty("MsgId")
	private long msgID;
	public String getMediaID() {
		return mediaID;
	}
	public void setMediaID(String mediaID) {
		this.mediaID = mediaID;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public long getMsgID() {
		return msgID;
	}
	public void setMsgID(long msgID) {
		this.msgID = msgID;
	}
	
	@JsonIgnore
	@Override
	public LogKeys getLogType(){
		return LogKeys.s_vo;
	}
	
	@JsonIgnore
	@Override
	public MessageType getMessageType() {
		return MessageType.voice;
	}

}
