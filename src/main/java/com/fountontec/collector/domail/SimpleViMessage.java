package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fountontec.collector.common.LogKeys;
import com.fountontec.collector.common.MessageType;

public class SimpleViMessage extends SimpleMessage{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("MediaId")
	private String mediaID;
	@JsonProperty("ThumbMediaId")
	private String thumbMediaID;
	@JsonProperty("MsgId")
	private long msgID;
	
	
	public String getMediaID() {
		return mediaID;
	}

	public void setMediaID(String mediaID) {
		this.mediaID = mediaID;
	}

	public String getThumbMediaID() {
		return thumbMediaID;
	}

	public void setThumbMediaID(String thumbMediaID) {
		this.thumbMediaID = thumbMediaID;
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
		return LogKeys.s_vi;
	}
	
	@JsonIgnore
	@Override
	public MessageType getMessageType() {
		return MessageType.video;
	}
	

}
