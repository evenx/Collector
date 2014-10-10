package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fountontec.collector.common.LogKeys;

public class EventQrsubMessage extends EventMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("EventKey")
	private String eventKey;
	@JsonProperty("Ticket")
	private String ticket;
	
	public String getEventKey() {
		return eventKey;
	}
	public void setEventKey(String eventKey) {
		this.eventKey = eventKey;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
	@JsonIgnore
	@Override
	public LogKeys getLogType(){
		return LogKeys.e_qrsub;
	}
	

}
