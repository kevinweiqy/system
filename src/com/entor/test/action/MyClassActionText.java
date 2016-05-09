package com.entor.test.action;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.action.MyClassAction;
import com.entor.model.MyClass;


public class MyClassActionText {

	AbstractApplicationContext context;
	MyClassAction myClassAction;
	
	@Before
	public void before() {
		// 先十里湖spring容器
		context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		myClassAction = (MyClassAction) context.getBean("myClassAction");
	}
	
	@Test
	public void add() throws UnsupportedEncodingException{
		MyClass myClass = new MyClass("度约翰","基尔加丹","古尔丹");
		myClassAction.setMyClass(myClass);
		String str = myClassAction.add();
		System.out.println(str);
	}
	
	@Test
	public void get() throws UnsupportedEncodingException{
		MyClass myClass = new MyClass("度约翰","基尔加丹","古尔丹");
		myClassAction.setMyClass(myClass);
		String str = myClassAction.add();
		System.out.println(str);
	}
	
	@Test
	public void delete() throws UnsupportedEncodingException{
		MyClass myClass = new MyClass();
		myClass.setId(41);
		myClassAction.setMyClass(myClass);
		String str = myClassAction.delete();
		System.out.println(str);
	}
	
	@Test
	public void getMyClassJsonByPageTest() throws UnsupportedEncodingException{
		myClassAction.setPage(5);
		myClassAction.setRows(6);
		String str = myClassAction.getMyClassJsonByPage();
		System.out.println(str);
	}
	
	@Test
	public void getones() throws UnsupportedEncodingException{
		MyClass myClass = new MyClass();
		myClass.setId(52);
//		myClassAction.setMyClass(myClass);
//		String str = myClassAction.selectOnesClass();
//		System.out.println(str);
		myClassAction.setMyClass(myClass);
		myClassAction.selectOnesClass();
	}
}
