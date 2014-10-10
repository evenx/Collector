package com.fountontec.collector.sender;

import com.fountontec.collector.common.ConfigUtils;

public class Header {

	private String p = ConfigUtils.getInstance().getClientID();

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}
	
}
