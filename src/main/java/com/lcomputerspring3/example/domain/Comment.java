package com.lcomputerspring3.example.domain;

public class Comment {

	private int cId;
	private String uId;
	private int bId;
	private String bComment;
	private String cDateTime;
	private int cGroup;
	private int cOrder;
	private int cDepth;
	
	
	
	
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public String getbComment() {
		return bComment;
	}
	public void setbComment(String bComment) {
		this.bComment = bComment;
	}
	public String getcDateTime() {
		return cDateTime;
	}
	public void setcDateTime(String cDateTime) {
		this.cDateTime = cDateTime;
	}
	public int getcGroup() {
		return cGroup;
	}
	public void setcGroup(int cGroup) {
		this.cGroup = cGroup;
	}
	public int getcOrder() {
		return cOrder;
	}
	public void setcOrder(int cOrder) {
		this.cOrder = cOrder;
	}
	public int getcDepth() {
		return cDepth;
	}
	public void setcDepth(int cDepth) {
		this.cDepth = cDepth;
	}
	
	@Override
	public String toString() {
		
		return super.toString();
	}
	
	
}
