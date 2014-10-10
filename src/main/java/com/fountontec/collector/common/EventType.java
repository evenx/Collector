package com.fountontec.collector.common;


import com.alibaba.fastjson.JSONObject;
import com.fountontec.collector.domail.EventClMessage;
import com.fountontec.collector.domail.EventLoMessage;
import com.fountontec.collector.domail.EventQrscanMessage;
import com.fountontec.collector.domail.EventQrsubMessage;
import com.fountontec.collector.domail.EventSsubMessage;
import com.fountontec.collector.domail.EventSusubMessage;
import com.fountontec.collector.domail.SingleMessage;

public enum EventType{

	LOCATION {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return EventLoMessage.class;
		}
		
	},subscribe {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			try {
				if(json.get(Common.MESSAGE_EVENT_EVENTKEY_KEY) != null){
					if(((String)json.get(Common.MESSAGE_EVENT_EVENTKEY_KEY)).startsWith(Common.MESSAGE_EVENT_EVENTKEY_QR_KEY)){
						return EventQrsubMessage.class;
					}
				}else{
					return EventSsubMessage.class;
				}
			} catch (Exception e) {
			}
			return EventSsubMessage.class;
		}
	},unsubscribe {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return EventSusubMessage.class;
		}
	},scan {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return EventQrscanMessage.class;
		}
	},CLICK {
		@Override
		public Class<? extends SingleMessage> getType(JSONObject json) {
			return EventClMessage.class;
		}
	};
	public abstract Class<? extends SingleMessage> getType(JSONObject json);
}
