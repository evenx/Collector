package com.fountontec.collector.domail;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonProperty;


public abstract class SimpleMessage extends Message{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("ToUserName")
	@NotNull
	private String toUserName;
	@JsonProperty("FromUserName")
	@NotNull
	private String fromUserName;
	@JsonProperty("CreateTime")
	@NotNull
	private long createTime;
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
	
	
}
