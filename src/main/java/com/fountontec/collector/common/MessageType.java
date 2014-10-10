package com.fountontec.collector.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.fountontec.collector.domail.CustomizedPfiMessage;
import com.fountontec.collector.domail.CustomizedPiMessage;
import com.fountontec.collector.domail.SimpleImMessage;
import com.fountontec.collector.domail.SimpleLiMessage;
import com.fountontec.collector.domail.SimpleLoMessage;
import com.fountontec.collector.domail.SimpleTeMessage;
import com.fountontec.collector.domail.SimpleViMessage;
import com.fountontec.collector.domail.SimpleVoMessage;
import com.fountontec.collector.domail.SingleMessage;

public enum MessageType {

	event {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			try {
				return EventType.valueOf((String)json.get(Common.MESSAGE_TYPE_EVENT_KEY)).getType(json);
			} catch (Exception e) {
				logger.error("event type invalid!");
			}
			return null;
		}
	},pd_init {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return CustomizedPiMessage.class;
		}
	},pd_fans_info {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return CustomizedPfiMessage.class;
		}
	},text {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return SimpleTeMessage.class;
		}
	},image {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return SimpleImMessage.class;
		}
	},voice {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return SimpleVoMessage.class;
		}
	},video {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return SimpleViMessage.class;
		}
	},location {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return SimpleLoMessage.class;
		}
	},link
	
	{
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return SimpleLiMessage.class;
		}
	};
	public abstract Class<? extends SingleMessage> getType(JSONObject json);
	private static final Logger logger = LoggerFactory.getLogger(EventType.class);
	
}
