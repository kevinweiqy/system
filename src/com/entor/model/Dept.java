package com.entor.model;

public class Dept {
	//部门模型
	private int id;//部门id
	private String name;//部门名称
	private String loc;//部门地址
	private Dept fatherDept;//父级，在数据库中不存在
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public Dept getFatherDept() {
		return fatherDept;
	}
	public void setFatherDept(Dept fatherDept) {
		this.fatherDept = fatherDept;
	}
	
}
