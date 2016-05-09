package com.entor.test.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.entor.model.Rightorwrong;
import com.entor.model.Select;
import com.entor.model.Student;
import com.entor.model.TestAnser;
import com.entor.model.TestPaper;
import com.entor.service.TestAnserService;
import com.entor.service.TestScoreService;
import com.entor.utils.PageUtil;


public class TestAnserServiceTest {
	AbstractApplicationContext context;
	   TestAnserService testAnserService;

	@Before
	public void before(){
		//先实例化spring容器
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		//再从容器里面
		//扫描名字默认为类名，首字母小写
		testAnserService=(TestAnserService)context.getBean("testAnserServiceImpl");
	}
	@Test
	public void addTestAnser(){
		TestAnser ta=new TestAnser();
		Student stu=new Student();
		TestPaper tp= new TestPaper();
		Select sel=new Select();
		Rightorwrong rtw=new Rightorwrong();
		ta.setStudent(stu);
		ta.setTestPaper(tp);
		ta.setSelect(sel);
		ta.setRightorwrong(rtw);
		ta.setRightorwrongAnswer(1);
		ta.setRwAnswer(1);
		
		
	}
	@Test
	public void getTestAnserByPage() throws UnsupportedEncodingException{
		TestAnser testAnser = new TestAnser();
		Student student = new Student();
		student.setId(5);
		TestPaper testPaper = new TestPaper();
		testPaper.setId(5);
		testAnser.setStudent(student);
		testAnser.setTestPaper(testPaper);
		PageUtil pu = new PageUtil();
		pu.setPageNo(1);
		pu.setSize(10);
		InputStream is=testAnserService.getTestAnserListByPage(testAnser, pu);
		System.out.println(is);
	}
	

}
