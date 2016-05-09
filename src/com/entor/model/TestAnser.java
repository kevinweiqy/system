package com.entor.model;

public class TestAnser {
	private int id;//主键
	private Student student;//学生表外键
	private TestPaper testPaper;//试卷表外键
	private Select select;//选择题外键
	private Rightorwrong rightorwrong;//判断题外键
	private int ssAnswer;//学生提交选择题答案
	private int SelectAnswer;//选择题标准答案
	private int rwAnswer;//学生提交判断题答案
	private int RightorwrongAnswer;//判断题标准答案
	
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public TestPaper getTestPaper() {
		return testPaper;
	}
	public void setTestPaper(TestPaper testPaper) {
		this.testPaper = testPaper;
	}

	public int getSsAnswer() {
		return ssAnswer;
	}
	public void setSsAnswer(int ssAnswer) {
		this.ssAnswer = ssAnswer;
	}
	public int getRwAnswer() {
		return rwAnswer;
	}
	public void setRwAnswer(int rwAnswer) {
		this.rwAnswer = rwAnswer;
	}
	public int getSelectAnswer() {
		return SelectAnswer;
	}
	public void setSelectAnswer(int selectAnswer) {
		SelectAnswer = selectAnswer;
	}
	public int getRightorwrongAnswer() {
		return RightorwrongAnswer;
	}
	public void setRightorwrongAnswer(int rightorwrongAnswer) {
		RightorwrongAnswer = rightorwrongAnswer;
	}
	public Select getSelect() {
		return select;
	}
	public void setSelect(Select select) {
		this.select = select;
	}
	public Rightorwrong getRightorwrong() {
		return rightorwrong;
	}
	public void setRightorwrong(Rightorwrong rightorwrong) {
		this.rightorwrong = rightorwrong;
	}
	
	

}
