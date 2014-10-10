package com.fountontec.collector.sender;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fountontec.collector.domail.SingleMessage;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class EventMessage {

	
	private List<SingleMessage> lo;
	private List<SingleMessage> ssub;
	private List<SingleMessage> susub;
	private List<SingleMessage> qrsub;
	private List<SingleMessage> qrscan;
	private List<SingleMessage> cl;

	public List<SingleMessage> initList(List<SingleMessage> list){
		if(list == null)
			return new ArrayList<SingleMessage>();
		else 
			return list;
	}
	
	public void add(SingleMessage log){
		switch(log.getLogType()){
		case e_lo:
		    lo = initList(lo);
		    lo.add(log);
			break;
		case e_ssub:
			ssub = initList(ssub);
			ssub.add(log);
			break;
		case e_susub:
			susub = initList(susub);
			susub.add(log);
			break;
		case e_qrsub:
			qrsub =  initList(qrsub);
			qrsub.add(log);
			break;
		case e_qrscan:
			qrscan = initList(qrscan);
			qrscan.add(log);
			break;
			default:
				cl = initList(cl);
				cl.add(log);
			
		}
	}
	
	public List<SingleMessage> getLo() {
		return lo;
	}
	public void setLo(List<SingleMessage> lo) {
		this.lo = lo;
	}
	public List<SingleMessage> getSsub() {
		return ssub;
	}
	public void setSsub(List<SingleMessage> ssub) {
		this.ssub = ssub;
	}
	public List<SingleMessage> getSusub() {
		return susub;
	}
	public void setSusub(List<SingleMessage> susub) {
		this.susub = susub;
	}
	public List<SingleMessage> getQrsub() {
		return qrsub;
	}
	public void setQrsub(List<SingleMessage> qrsub) {
		this.qrsub = qrsub;
	}
	public List<SingleMessage> getQrscan() {
		return qrscan;
	}
	public void setQrscan(List<SingleMessage> qrscan) {
		this.qrscan = qrscan;
	}
	public List<SingleMessage> getCl() {
		return cl;
	}
	public void setCl(List<SingleMessage> cl) {
		this.cl = cl;
	}
	
	
}
