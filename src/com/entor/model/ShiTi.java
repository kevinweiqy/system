package com.entor.model;

public class ShiTi {
	private int id;//id
	private String shiti_code;//试题编号
	private String neirong;//试题内容
	private int type;//试题类型 1判断题  0单选题 2多选题
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShiti_code() {
		return shiti_code;
	}
	public void setShiti_code(String shitiCode) {
		shiti_code = shitiCode;
	}
	public String getNeirong() {
		return neirong;
	}
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
