package com.entor.test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.entor.dao.MyClassDao;
import com.entor.model.MyClass;
import com.entor.model.Student;
import com.entor.utils.PageUtil;

public class MyClassDaoText {
		// spring容器对象
		AbstractApplicationContext context;
		MyClassDao myClassDao;

		@Before
		public void before() {
			// 先十里湖spring容器
			context = new ClassPathXmlApplicationContext(
					new String[] { "applicationContext.xml" });
			myClassDao = (MyClassDao) context.getBean("myClassDaoImpl");
		}
	
	/**
	 * 添加测试
	 */
	@Test
	public void addText(){
			MyClass myClass = new MyClass("class2","className1","major1");
			myClassDao.save(myClass);
		
	}
	
	/**
	 * 删除测试
	 */
	@Test
	public void deleteText(){
		MyClass myClass = new MyClass();
		myClass.setId(27);
	    myClassDao.delete(myClass);
	    
	}
	
	/**
	 * 查询测试
	 */
	@Test
	public  void getText(){
		MyClass myClass = 
	    (MyClass)myClassDao.get(MyClass.class, 1);
		myClass.setClassName("36D奶");
		myClass.setMajor("36D奶");
		myClassDao.update(myClass);
		System.out.println(myClass.getClassName());
	}
	/**
	 * 更新测试
	 */
	@Test
	public void updateText(){
		MyClass myClass = 
            new MyClass("classNumber1","36D奶","36D奶");
		myClassDao.update(myClass);
	}
	


	
	/**
	 * 分页查询方法测试
	 */
	@Test
	public void getMyClassListByPageText(){
		MyClass myClass = new MyClass();
		myClass.setId(1);
		PageUtil pu = new PageUtil();
		pu.setPageNo(2);
		pu.setSize(5);
		List<MyClass> list =
			myClassDao.getMyClassListByPage(myClass, pu);
		for(MyClass myClass2 : list){
			System.out.println(myClass2.getId());
		}
	}
	
	/**
	 * 获得总的记录数
	 */
	@Test
	public void getTotolRecordsTest(){
		MyClass myClass = new MyClass();
		myClass.setId(20);
		long num=
			myClassDao.getTotolRecords(myClass);
			System.out.println(num);
	}
	
}
