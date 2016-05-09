package com.entor.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.TestScoreDao;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;

public class TestScoreTest {
	private ApplicationContext context;
	
	private TestScoreDao td;
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		td = (TestScoreDao)context.getBean("testScoreDaoImpl");
	}
	@Test
	public void getscore(){
		TestPaper tp=new TestPaper();
		tp.setId(6);
		Student stu=new Student();
		stu.setId(6);
		TestScore testScore=td.getTestScore(tp, stu);
		System.out.println(testScore.getId());
	    
	}
}
