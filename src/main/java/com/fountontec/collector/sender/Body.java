package com.fountontec.collector.sender;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fountontec.collector.domail.SingleMessage;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class Body {

	private EventMessage em;
	private SimpleMessage sm;
	
	public void addMessage(SingleMessage log){
		switch(log.getMessageType()){
		case event:
			if(em == null)
				em = new EventMessage();
			em.add(log);
			break;
			default:
				if(sm == null)
					sm = new SimpleMessage();
				sm.add(log);
		}
	}

	public SimpleMessage getSm() {
		return sm;
	}

	public void setSm(SimpleMessage sm) {
		this.sm = sm;
	}

	public EventMessage getEm() {
		return em;
	}

	public void setEm(EventMessage em) {
		this.em = em;
	}
	
	
}
