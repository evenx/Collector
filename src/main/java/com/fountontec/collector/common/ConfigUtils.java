package com.fountontec.collector.common;



public class ConfigUtils {

	private static Config config;
	static{
		config = (Config)SpringHelper.getBean("config");
	}
	private ConfigUtils(){}
	
    private static final ConfigUtils singleton = new ConfigUtils();
	
	public static ConfigUtils getInstance(){
		return singleton;
	}
	
	
	public String getAccepterUrl(){
		return config.getAccepterUrl();
	}
	
	public String getLocalIP(){
		return config.getLocalIP();
	}
	
	public String getPacketLogDir(){
		return config.getPacketLogDir();
	}
	
	public String getSimpleLogDir(){
		return config.getSimpleLogDir();
	}
	
	public int getp(){
		return config.getBindPort();
	}
	
	public String getClientID(){
		return config.getClientID();
	}
	
	public int getMaxMessages(){
		return config.getMaxMessages();
	}
	
}
