package com.fountontec.collector.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

	@Value("${accepter.host.url}")
	private String accepterUrl;
	
	@Value("${local.ip}")
	private String localIP;
	
	@Value("${local.bind.port}")
	private int bindPort;
	
	@Value("${simple.log.dir}")
	private String simpleLogDir;
	
	@Value("${packet.log.dir}")
	private String packetLogDir;
	
	@Value("${client.id}")
	private String clientID;
	
	@Value("${max.send.message}")
	private int maxMessages;

	public int getMaxMessages() {
		return maxMessages;
	}

	public String getClientID() {
		return clientID;
	}

	public String getAccepterUrl() {
		return accepterUrl;
	}

	public int getBindPort() {
		return bindPort;
	}

	public String getSimpleLogDir() {
		return simpleLogDir;
	}

	public String getPacketLogDir() {
		return packetLogDir;
	}

	public String getLocalIP() {
		return localIP;
	}
	
}
