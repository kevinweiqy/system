package com.entor.model;

public class MyClass {

	private int id;
	private String classNumber;//班级编号
	private String className;//班级名称
	private String major;//专业
	
	public MyClass(){
		
	}
	
    public MyClass(String classNumber,String className,String major){
		this.className=className;
		this.classNumber=classNumber;
		this.major=major;
	}
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassNumber() {
		return classNumber;
	}
	public void setClassNumber(String classNumber) {
		this.classNumber = classNumber;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
	
}
