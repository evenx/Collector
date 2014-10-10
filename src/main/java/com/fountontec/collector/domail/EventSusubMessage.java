package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.fountontec.collector.common.LogKeys;

public class EventSusubMessage extends EventMessage{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Override
	public LogKeys getLogType(){
		return LogKeys.e_susub;
	}

}
