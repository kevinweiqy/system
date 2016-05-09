package com.entor.test.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.MyClassDao;
import com.entor.model.MyClass;
import com.entor.model.Student;
import com.entor.service.MyClassService;
import com.entor.utils.PageUtil;

public class MyClassServicText {

	// spring容器对象
	AbstractApplicationContext context;
	MyClassService myClassService;
	//MyClassDao myClassDao;
	@Before
	public void before() {
		// 先十里湖spring容器
		context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		myClassService = (MyClassService) context.getBean("myClassServiceImpl");
		//myClassDao = (MyClassDao) context.getBean("myClassDaoImpl");

	}
	/**
	 * 添加测试
	 */
	@Test
	public void addText(){
		
			MyClass myClass = new MyClass("古娜拉","className","major");
			myClassService.addMyClass(myClass);
		
	}
	
	/**
	 * 删除测试
	 */
	@Test
	public void deleteText(){
		MyClass myClass = new MyClass();
		myClass.setId(38);
		myClassService.deleteMyClass(myClass);
	}

	


	
	/**
	 * 分页查询方法测试
	 * @throws UnsupportedEncodingException 
	 */
	@Test
	public void getMyClassListByPageText() throws UnsupportedEncodingException{
		MyClass myClass = new MyClass();
		myClass.setId(1);
		PageUtil pu = new PageUtil();
		pu.setPageNo(2);
		pu.setSize(5);
		List<MyClass> list =
			(List<MyClass>) myClassService.getMyClassListJsonByPage(myClass, pu);
		for(MyClass myClass2 : list){
			System.out.println(myClass2);
		}
	}
	
}
