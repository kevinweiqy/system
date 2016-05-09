package com.entor.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.model.QX_INFO;
import com.entor.model.Student;
import com.entor.service.StudentService;



public class StudentServiceTest {

	AbstractApplicationContext context;
	StudentService studentService = null;
	
	
	//做单元测试前必须要有一个@Before先加载
	@Before //这叫注解,要做单元测试,就必须要有注解,否则系统不会认为这是一个单元，就测试不了
	public void before(){
		System.out.println("before");
		//做单元测试之前，先实例化spring容器
		//获得一个spring容器
		context = new ClassPathXmlApplicationContext(
					new String[]{"applicationContext.xml"});
		studentService = 
			(StudentService)context.getBean("studentServiceImpl");//注意getBean这里名称不要打错，打错就会报no define
	}
	
	//添加
	@Test
	public void StudentAddTest() throws Exception {
		Student student = new Student();
		student.setStudentNumber("1008");
	    student.setStudentname("qwer");
	    student.setSex(0);
//	    student.setMyClass();
	    student.setStudentpassword("1234");
	    studentService.studentAdd(student);
	}
	
	//删除
	@Test
	public void StudentdeleteTest() throws Exception {
		Student student = studentService.getStudent(7);
//		student.setId(7);
		studentService.Studentdelete(student);
	}
	
	//更新
	@Test
	public void StudentupdateTest() throws Exception {
		Student student=studentService.getStudent(1);
     	student.setStudentname("adcde");
		student.setStudentpassword("12382");
		studentService.Studentupdate(student);
		
	}
	//查询ID
	@Test
	public void getStudentTest(){
		Student stu=studentService.getStudent(1);
		System.out.println(stu.getStudentname());
	}
	//查列表
	@Test
	public void getAllStudentTest(){
		List<Student> list = studentService.getAllStudentList(null);
		for (Student student: list) {
			System.out.println(student.getId());
			System.out.println(list);
		}
	}
		
	
	
	
}
