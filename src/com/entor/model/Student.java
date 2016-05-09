package com.entor.model;

import java.util.Date;

public class Student {

	private int id;//Id
	private String studentNumber;//学号
	private String studentname;//姓名
	private int sex;//性别
	private MyClass myClass;//所在班级
	private String studentpassword;//密码
	private Date registerdate;//注册日期
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	
	public String getStudentpassword() {
		return studentpassword;
	}
	public void setStudentpassword(String studentpassword) {
		this.studentpassword = studentpassword;
	}
	public Date getRegisterdate() {
		return registerdate;
	}
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}
	public MyClass getMyClass() {
		return myClass;
	}
	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
	}
	
	
	
}
