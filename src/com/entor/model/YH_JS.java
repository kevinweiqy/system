package com.entor.model;

import java.io.Serializable;

public class YH_JS implements Serializable{
	private static final long serialVersionUID = 7247923299900339540L;
	private JS_XX js_xx;
	private Admin admin;
	public JS_XX getJs_xx() {
		return js_xx;
	}
	public void setJs_xx(JS_XX jsXx) {
		js_xx = jsXx;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
}
