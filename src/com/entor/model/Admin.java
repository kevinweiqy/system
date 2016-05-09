package com.entor.model;

public class Admin {
	//管理员模型
	private int id;
	private String admin_number;//管理员账号
	private String admin_name;//管理员姓名      非空
	private String admin_password;//密码 		非空
	private String specialty;//专业
	private String email;//邮箱
	private String phone;//电话
	private int status;//是否在职业。1在0否    非空
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdmin_number() {
		return admin_number;
	}
	public void setAdmin_number(String adminNumber) {
		admin_number = adminNumber;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String adminName) {
		admin_name = adminName;
	}
	public String getAdmin_password() {
		return admin_password;
	}
	public void setAdmin_password(String adminPassword) {
		admin_password = adminPassword;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
