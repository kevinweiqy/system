package com.entor.model;

import java.util.Date;

public class TestPaper {

	private int id;//ID
	private int examination_no;//试卷编号
	private int rightorwrong_number;//判断题数
	private int rightorwrong_score;//判断题每题分数
	private int select_number;//单选择题数
	private int select_score;//单选择题每题分数
	private int selects_number;//多选择题数
	private int selects_score;//多选择题每题分数
	private Date setupDate;//出试卷日期
	private Date beginTime;//开始日期
	private Date endTime;//结束日期
	private int status;//试卷状态 1 开始 2 进行中 3 结束
	private Admin  teacher;//出卷老师
	private String detail;//试卷说明
	private int test_type;//类型  0 补考试卷1 非补考试卷
	private int pass_score;//合格分数
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getExamination_no() {
		return examination_no;
	}
	public void setExamination_no(int examinationNo) {
		examination_no = examinationNo;
	}
	public int getRightorwrong_number() {
		return rightorwrong_number;
	}
	public void setRightorwrong_number(int rightorwrongNumber) {
		rightorwrong_number = rightorwrongNumber;
	}
	public int getRightorwrong_score() {
		return rightorwrong_score;
	}
	public void setRightorwrong_score(int rightorwrongScore) {
		rightorwrong_score = rightorwrongScore;
	}
	public int getSelect_number() {
		return select_number;
	}
	public void setSelect_number(int selectNumber) {
		select_number = selectNumber;
	}
	public int getSelect_score() {
		return select_score;
	}
	public void setSelect_score(int selectScore) {
		select_score = selectScore;
	}
	public int getSelects_number() {
		return selects_number;
	}
	public void setSelects_number(int selectsNumber) {
		selects_number = selectsNumber;
	}
	public int getSelects_score() {
		return selects_score;
	}
	public void setSelects_score(int selectsScore) {
		selects_score = selectsScore;
	}
	public Date getSetupDate() {
		return setupDate;
	}
	public void setSetupDate(Date setupDate) {
		this.setupDate = setupDate;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	public Admin getTeacher() {
		return teacher;
	}
	public void setTeacher(Admin teacher) {
		this.teacher = teacher;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getTest_type() {
		return test_type;
	}
	public void setTest_type(int testType) {
		test_type = testType;
	}
	public int getPass_score() {
		return pass_score;
	}
	public void setPass_score(int passScore) {
		pass_score = passScore;
	}
}
