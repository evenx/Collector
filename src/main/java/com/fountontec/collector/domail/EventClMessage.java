package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fountontec.collector.common.LogKeys;

public class EventClMessage extends EventMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("EventKey")
	private String eventKey;
	
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	
	@JsonIgnore
	@Override
	public LogKeys getLogType(){
		return LogKeys.e_cl;
	}

}
