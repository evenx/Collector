package com.fountontec.collector.domail;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import com.fountontec.collector.common.LogKeys;
import com.fountontec.collector.common.MessageType;

public class CustomizedPfiMessage extends CustomizedMessage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long subscribe;
	@JsonProperty("openid")
	private String openID;
	@JsonProperty("nickname")
	private String nickName;
	private long sex;
	private String language;
	private String city;
	private String province;
	private String country;
	@JsonProperty("headimgurl")
	private String headImgUrl;
	@JsonProperty("subscribe_time")
	private long subscribeTime;
	
	public long getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(long subscribe) {
		this.subscribe = subscribe;
	}
	public String getOpenID() {
		return openID;
	}
	public void setOpenID(String openID) {
		this.openID = openID;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public long getSex() {
		return sex;
	}
	public void setSex(long sex) {
		this.sex = sex;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadImgUrl() {
		return headImgUrl;
	}
	public void setHeadImgUrl(String headImgUrl) {
		this.headImgUrl = headImgUrl;
	}
	public long getSubscribeTime() {
		return subscribeTime;
	}
	public void setSubscribe_time(long subscribeTime) {
		this.subscribeTime = subscribeTime;
	}
	@JsonIgnore
	@Override
	public LogKeys getLogType(){
		return LogKeys.s_pfi;
	}
	
	@JsonIgnore
	@Override
	public MessageType getMessageType() {
		return MessageType.pd_fans_info;
	}
	

}
