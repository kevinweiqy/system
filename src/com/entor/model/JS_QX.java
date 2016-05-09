package com.entor.model;

import java.io.Serializable;

public class JS_QX implements Serializable {
	/**
	 *  角色权限 和权限 信息的中间表
	 */
	private static final long serialVersionUID = 1L;
	private  JS_XX js_xx; //角色id
	private  QX_INFO qx_info; // 权限id
	
	
	
	public JS_XX getJs_xx() {
		return js_xx;
	}
	public void setJs_xx(JS_XX jsXx) {
		js_xx = jsXx;
	}
	public QX_INFO getQx_info() {
		return qx_info;
	}
	public void setQx_info(QX_INFO qxInfo) {
		qx_info = qxInfo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
	
	
	

}
