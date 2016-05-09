package com.entor.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.entor.dao.StudentDao;


import com.entor.model.Student;
import com.entor.utils.PageUtil;


public class StudentTest {
	AbstractApplicationContext context;
    StudentDao ad=null;
	@Before
	public void before(){
		//先实例化spring容器
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		//再从容器里面
		//扫描名字默认为类名，首字母小写
	    ad=(StudentDao)context.getBean("studentDaoImpl");
	}
	//增加
	@Test
	public void StudentAdd() {
	    Student student=new Student();
//	    student.setId(001);
	    student.setStudentNumber("1006");
	    student.setStudentname("gsad");
	    student.setSex(0);
//	    student.setMyClass();
	    student.setStudentpassword("123456");
	   
	    ad.save(student);	 
   } 
	//删除
	@Test
	public void Studentdelete() {
	    Student student=new Student();
	    student.setId(004);
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
		pu.setSize(2);
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
}

