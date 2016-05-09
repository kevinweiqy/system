package com.entor.model;

import java.util.Date;

public class TestScore {

	private int id;//id
	private TestPaper tp;//试卷
	private Student stu;//学生
	private int score;//成绩
	private Date examinationdate;//考试日期
	private int pass;//是否补考  
	private int buScore;//补考成绩
	private int isPass;//是否及格
	private String detail;//说明
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TestPaper getTp() {
		return tp;
	}
	public void setTp(TestPaper tp) {
		this.tp = tp;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Date getExaminationdate() {
		return examinationdate;
	}
	public void setExaminationdate(Date examinationdate) {
		this.examinationdate = examinationdate;
	}
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public int getBuScore() {
		return buScore;
	}
	public void setBuScore(int buScore) {
		this.buScore = buScore;
	}
	public int getIsPass() {
		return isPass;
	}
	public void setIsPass(int isPass) {
		this.isPass = isPass;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
}
