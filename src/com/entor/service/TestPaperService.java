package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.entor.model.MyClass;
import com.entor.model.ShiTi;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.utils.PageUtil;

public interface TestPaperService {
	
	//添加
	public void addTestPaperService(TestPaper tp);
	//删除
	public void deleteTestPaperService(TestPaper tp);
	//更新
	public void updateTestPaperService(TestPaper tp);
	//获取一张试卷信息的流
	public InputStream getTestPaperService (int id) throws UnsupportedEncodingException; 
	//获取一张试卷的对象
	public TestPaper getPaperService(TestPaper tp);
	//添加默认试题
	public void addDefaultPaperService(TestPaper tp);
	//分页
	public InputStream getTestPaperListByPageService(TestPaper tp,PageUtil pu)throws UnsupportedEncodingException;
    //获取试题的接口
	public InputStream getShiTiService(ShiTi st, PageUtil pu) throws UnsupportedEncodingException;
    //保存手动添加试题的接口
	public void savePaperShiTiService(String s);
	
	//通过学生班级找学生信息
	public void addTestStudents(TestPaper tp,MyClass myClass);
}
