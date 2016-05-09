package com.entor.test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.ShiTiDao;
import com.entor.dao.TestAnserDao;
import com.entor.model.Student;
import com.entor.model.TestAnser;
import com.entor.model.TestPaper;
import com.entor.utils.PageUtil;

public class TestAnserDaoTest {

	AbstractApplicationContext context;
	TestAnserDao testAnserDao;
	@Before
	public void before(){
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		testAnserDao=(TestAnserDao)context.getBean("testAnserDaoImpl");
	}
	@Test
	public void getTestAnserByPage(){
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
		List list=testAnserDao.getTestAnserListByPage(testAnser, pu);
		System.out.println(list.size());
	}
	@Test
	public void getTotal(){
		TestAnser testAnser = new TestAnser();
		Student student = new Student();
		student.setId(5);
		TestPaper testPaper = new TestPaper();
		testPaper.setId(5);
		testAnser.setStudent(student);
		testAnser.setTestPaper(testPaper);
	    long total=testAnserDao.getTotal(testAnser);
		System.out.println(total);
	}
}
