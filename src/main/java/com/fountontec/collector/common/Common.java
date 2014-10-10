package com.fountontec.collector.common;

public interface Common {

	
	public static final String DEFAULT_CHARSET = "utf-8";
	public static final String ADDRESS_WEXIN = "wechat";
	public static final String USER_AGENT = "Allyes_PD_Collector";
	
	public static final String MESSAGE_TYPE_KEY = "MsgType";
	public static final String MESSAGE_TYPE_EVENT_KEY = "Event";
	public static final String MESSAGE_EVENT_EVENTKEY_KEY = "EventKey";
	public static final String MESSAGE_EVENT_EVENTKEY_QR_KEY = "qrsc";
	
	public static final String LOG_CREATED_KEY = "created";
	public static final String LOG_VALUE_KEY = "value";
	
	//日志文件名称 ;修改此处需要关联logback.xml中配置
	public static final String LOG_FILE_NAME_SIMPLE = "pd_collector_message.log.";
	public static final String LOG_FILE_NAME_PACK = "pd_collector_pack.log.";
	
	
}
