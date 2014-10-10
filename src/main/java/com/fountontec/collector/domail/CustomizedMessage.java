package com.fountontec.collector.domail;

import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

public abstract class CustomizedMessage extends Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull@NotEmpty
	@JsonProperty("ToUserName")
	private String toUserName;
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	

}
