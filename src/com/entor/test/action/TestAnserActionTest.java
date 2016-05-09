package com.entor.test.action;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.action.testAnser.TestAnserAction;
import com.entor.model.Student;
import com.entor.model.TestAnser;
import com.entor.model.TestPaper;

public class TestAnserActionTest {

	AbstractApplicationContext context;
	TestAnserAction testAnserAction;
	
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		testAnserAction = (TestAnserAction) context.getBean("testAnserAction");
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
//		testAnserAction.setTestAnser(testAnser);
		testAnserAction.getTestAnserByPage();
		System.out.println(testAnserAction.getInputStream());
	}
}
