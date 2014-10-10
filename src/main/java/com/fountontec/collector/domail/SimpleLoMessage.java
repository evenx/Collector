package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fountontec.collector.common.LogKeys;
import com.fountontec.collector.common.MessageType;

public class SimpleLoMessage extends SimpleMessage{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("Location_X")
	private long locationX;
	@JsonProperty("Location_Y")
	private long locationY;
	@JsonProperty("Scale")
	private long scale;
	@JsonProperty("Label")
	private String label;
	@JsonProperty("MsgId")
	private long msgID;
	
	public long getLocationX() {
		return locationX;
	}

	public void setLocation_X(long locationX) {
		this.locationX = locationX;
	}

	public long getLocationY() {
		return locationY;
	}

	public void setLocation_Y(long locationY) {
		this.locationY = locationY;
	}

	public long getScale() {
		return scale;
	}

	public void setScale(long scale) {
		this.scale = scale;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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
		return LogKeys.s_lo;
	}
	
	@JsonIgnore
	@Override
	public MessageType getMessageType() {
		return MessageType.location;
	}
}
