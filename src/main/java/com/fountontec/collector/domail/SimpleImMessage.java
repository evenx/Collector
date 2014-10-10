package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fountontec.collector.common.LogKeys;
import com.fountontec.collector.common.MessageType;

public class SimpleImMessage extends SimpleMessage{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("PicUrl")
	private String picUrl;
	@JsonProperty("MediaId")
	private String mediaID;
	@JsonProperty("MsgId")
	private long msgID;
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getMediaID() {
		return mediaID;
	}
	public void setMediaID(String mediaID) {
		this.mediaID = mediaID;
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
		return LogKeys.s_im;
	}
	
	@JsonIgnore
	@Override
	public MessageType getMessageType() {
		return MessageType.image;
	}

}
