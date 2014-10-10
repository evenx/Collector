package com.fountontec.collector.sender;

import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Log {

    private Header h = new Header();
    private Body b = new Body();
	 
	public Header getH() {
		return h;
	}
	public void setH(Header h) {
		this.h = h;
	}
	public Body getB() {
		return b;
	}
	public void setB(Body b) {
		this.b = b;
	}
	 
	 
}
