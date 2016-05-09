package com.entor.model;

public class JS_XX {
	private int id;
	private String js_no;//角色编号
	private String js_name;//角色名称
	private String js_detail;//角色描述
	private int js_status;//角色状态  1在用，2停用
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJs_no() {
		return js_no;
	}
	public void setJs_no(String jsNo) {
		js_no = jsNo;
	}
	public String getJs_name() {
		return js_name;
	}
	public void setJs_name(String jsName) {
		js_name = jsName;
	}
	public String getJs_detail() {
		return js_detail;
	}
	public void setJs_detail(String jsDetail) {
		js_detail = jsDetail;
	}
	public int getJs_status() {
		return js_status;
	}
	public void setJs_status(int jsStatus) {
		js_status = jsStatus;
	}

}
