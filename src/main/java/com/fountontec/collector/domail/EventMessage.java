package com.fountontec.collector.domail;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import com.fountontec.collector.common.MessageType;

public abstract class EventMessage extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("ToUserName")
	@NotNull@NotEmpty
	private String toUserName;
	@JsonProperty("FromUserName")
	@NotNull@NotEmpty
	private String fromUserName;
	@JsonProperty("CreateTime")
	private long createTime;
	@NotNull@NotEmpty
	@JsonProperty("Event")
	private String event;
	
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	
	@JsonIgnore
	@Override
	public MessageType getMessageType() {
		return MessageType.event;
	}

}
