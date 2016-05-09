package com.entor.test.dao;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.entor.dao.MyClassDao;
import com.entor.dao.StudentDao;


import com.entor.model.MyClass;
import com.entor.model.Student;
import com.entor.utils.PageUtil;


public class StudentDaoTest {
	AbstractApplicationContext context;
    StudentDao ad=null;
    MyClassDao mc = null;
	@Before
	public void before(){
		//先实例化spring容器
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		//再从容器里面
		//扫描名字默认为类名，首字母小写
	    ad=(StudentDao)context.getBean("studentDaoImpl");
	    mc=(MyClassDao)context.getBean("myClassDaoImpl");
	}
	//增加
	@Test
	public void StudentAdd() {
	    Student student=new Student();
//	    student.setId(001);
//	    student.setStudentNumber("1011");
//	    student.setStudentname("kfas");
//	    student.setSex(0);
//	    MyClass myClass=mc.get(MyClass.class, 4);
//	    student.setMyClass(myClass);
//	    student.setStudentpassword("16656");
//	    Date date = new Date();
//	    student.setRegisterdate(date);
//	   
//	    ad.save(student);	 
	    for(int i=11;i<=25;i++){
	    	student.setId(i-10);
	    	student.setStudentname("1000"+(i-10));
	    	student.setStudentNumber("2015"+(i-10));
	    	student.setSex(0);
	    	MyClass myClass=mc.get(MyClass.class, i);
	    	student.setMyClass(myClass);
	    	student.setStudentpassword("16656");
	    	Date date = new Date();
	    	student.setRegisterdate(date);
	    	ad.save(student);	
	    }
   } 
	//删除
	@Test
	public void Studentdelete() {
	    Student student=new Student();
	    student.setId(8);
//	    student.setStudentNumber("1003");
//	    student.setStudentname("wuwa");
//	    student.setSex(0);
//	    student.setMyClass();
//	    student.setStudentpassword("123456");
	   
	    ad.delete(student);	 
   } 
	//更新
	@Test
	public void Studentupdate(){
		Student student = 
			(Student)ad.get(Student.class, 1);
		student.setStudentname("adc");
		student.setStudentpassword("123");
		 MyClass myClass=mc.get(MyClass.class, 2);
		    student.setMyClass(myClass);
		ad.update(student);
	}
	//查询所有
	@Test
	public void getAllStudentListTest(){
		List<Student> list = ad.getAllStudentList();
		System.out.println(list);
	}
	

	
	//条件(模糊)查询(带分页)
	@Test
	public void getStudentListTestByPage(){
		Student student = new Student();
		student.setId(0);
		PageUtil pu = new PageUtil();
		pu.setPageNo(1);
		pu.setSize(9);
		List<Student> list = 
			ad.getStudentListByPage(student, pu);
		for (Student student2 : list) {
			System.out.println(student2.getId());
		}
	}
	
	//获取总的记录数
	@Test
	public void getTotalRecords(){
		long num = 
			ad.getTotalRecords(null);
		System.out.println(num);
	}
	@Test
	public void getStudent(){
		Student student = new Student();
		student.setStudentNumber("102");
		student.setStudentpassword("123");
		ad.getStudent(student.getStudentNumber(), student.getStudentpassword());

	}
}

