package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fountontec.collector.common.LogKeys;

public class EventLoMessage extends EventMessage{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("Latitude")
	private long latitude;
	@JsonProperty("Longitude")
	private long longitude;
	@JsonProperty("Precision")
	private long precision;
	
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	public long getPrecision() {
		return precision;
	}
	public void setPrecision(long precision) {
		this.precision = precision;
	}
	
	@JsonIgnore
	@Override
	public LogKeys getLogType(){
		return LogKeys.e_lo;
	}
	
}
