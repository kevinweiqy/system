package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.utils.PageUtil;
import com.sun.corba.se.spi.orbutil.fsm.Input;

public interface TestScoreService {
	//添加
	public void addTestScore(TestScore testScore);
	//删除
	public void deleteTestScore(TestScore testScore);
	//更新
	public void updateTestScore(TestScore testScore);
	
	//根据试卷和学生查找考试成绩
	public TestScore getTestScoreService(TestPaper tp,Student stu);
	
	//分页
	public InputStream getTestScoreListByPage(TestScore testScore,PageUtil pu)throws UnsupportedEncodingException;
	
	
	public InputStream getTestScoreById(int id) throws UnsupportedEncodingException;
	
	//查询一个学生成绩的方法
	public InputStream getStudentScore(Student stu) throws UnsupportedEncodingException;

}
