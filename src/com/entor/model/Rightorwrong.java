package com.entor.model;

import java.util.Date;

public class Rightorwrong extends ShiTi{

	private int rightorwrongid;//ID
	private int answer;//正确答案 1 对 0 错
	private Date sctupdate;//加入日期
	private int teacherid;//出题教师ID
	
	public int getRightorwrongid() {
		return rightorwrongid;
	}
	public void setRightorwrongid(int rightorwrongid) {
		this.rightorwrongid = rightorwrongid;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public Date getSctupdate() {
		return sctupdate;
	}
	public void setSctupdate(Date sctupdate) {
		this.sctupdate = sctupdate;
	}
	public int getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}
	
}
