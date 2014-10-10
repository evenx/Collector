package com.fountontec.collector.sender;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.fountontec.collector.domail.SingleMessage;


@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class SimpleMessage {

	private List<SingleMessage> pi;
	private List<SingleMessage> pfi;
	private List<SingleMessage> te;
	private List<SingleMessage> im;
	private List<SingleMessage> vo;
	private List<SingleMessage> vi;
	private List<SingleMessage> lo;
	private List<SingleMessage> li;
	
	public List<SingleMessage> initList(List<SingleMessage> list){
		if(list == null)
			return new ArrayList<SingleMessage>();
		else 
			return list;
	}
	
	public void add(SingleMessage log){
		switch(log.getLogType()){
		case s_pi:
		    pi = initList(pi);
		    pi.add(log);
			break;
		case s_pfi:
			pfi = initList(pfi);
			pfi.add(log);
			break;
		case s_te:
			te = initList(te);
			te.add(log);
			break;
		case s_im:
			im = initList(im);
			im.add(log);
			break;
		case s_vo:
			vo = initList(vo);
			vo.add(log);
			break;
		case s_vi:
			vi = initList(vi);
			vi.add(log);
			break;
		case s_lo:
			lo = initList(lo);
			lo.add(log);
			break;
			default:
				li = initList(li);
				li.add(log);
			
		}
	}
	
	public List<SingleMessage> getPi() {
		return pi;
	}
	public void setPi(List<SingleMessage> pi) {
		this.pi = pi;
	}
	public List<SingleMessage> getPfi() {
		return pfi;
	}
	public void setPfi(List<SingleMessage> pfi) {
		this.pfi = pfi;
	}
	public List<SingleMessage> getTe() {
		return te;
	}
	public void setTe(List<SingleMessage> te) {
		this.te = te;
	}
	public List<SingleMessage> getIm() {
		return im;
	}
	public void setIm(List<SingleMessage> im) {
		this.im = im;
	}
	public List<SingleMessage> getVo() {
		return vo;
	}
	public void setVo(List<SingleMessage> vo) {
		this.vo = vo;
	}
	public List<SingleMessage> getVi() {
		return vi;
	}
	public void setVi(List<SingleMessage> vi) {
		this.vi = vi;
	}
	public List<SingleMessage> getLo() {
		return lo;
	}
	public void setLo(List<SingleMessage> lo) {
		this.lo = lo;
	}
	public List<SingleMessage> getLi() {
		return li;
	}
	public void setLi(List<SingleMessage> li) {
		this.li = li;
	}
	
	
}
