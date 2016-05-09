package com.entor.model;

import java.io.Serializable;
/**管理员--部门抽象模型*/
public class AdminDept implements Serializable{
	private static final long serialVersionUID = 2L;
	private Admin admin;
	private Dept dept;
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
