package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fountontec.collector.common.LogKeys;
import com.fountontec.collector.common.MessageType;

public class SimpleLiMessage extends SimpleMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("Title")
	private String title;
	@JsonProperty("Description")
	private String description;
	@JsonProperty("Url")
	private String url;
	@JsonProperty("MsgId")
	private long msgId;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public long getMsgId() {
		return msgId;
	}
	public void setMsgId(long msgId) {
		this.msgId = msgId;
	}
	
	@JsonIgnore
	@Override
	public LogKeys getLogType(){
		return LogKeys.s_li;
	}

	@JsonIgnore
	@Override
	public MessageType getMessageType() {
		return MessageType.link;
	}
	
}
