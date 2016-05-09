package com.entor.test.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.entor.action.student.StudentAction;
import com.entor.dao.MyClassDao;
import com.entor.dao.StudentDao;

import com.entor.model.MyClass;
import com.entor.model.Student;
import com.entor.utils.PageUtil;




public class StudentActionTest {

	AbstractApplicationContext context;
	StudentAction studentAction = null;
	MyClassDao mc = null;
	StudentDao studentDao;
	//做单元测试前必须要有一个@Before先加载
	@Before //这叫注解,要做单元测试,就必须要有注解,否则系统不会认为这是一个单元，就测试不了
	public void before(){
		System.out.println("before");
		//做单元测试之前，先实例化spring容器
		//获得一个spring容器
		context = new ClassPathXmlApplicationContext(
					new String[]{"applicationContext.xml"});
		studentAction = 
			(StudentAction)context.getBean("studentAction");//注意getBean这里名称不要打错，打错就会报no define
		mc=(MyClassDao)context.getBean("myClassDaoImpl");
		studentDao=(StudentDao)context.getBean("studentDaoImpl");
	}
	//增加
	@Test
	public void StudentAddTest() throws UnsupportedEncodingException{
		Student student = new Student();
		student.setStudentNumber("77868");
		student.setStudentname("妈个鸡");
		MyClass myClass=mc.get(MyClass.class, 6);
		student.setMyClass(myClass);
		student.setSex(1);
		student.setStudentpassword("日了狗");
		Date date = new Date();
		student.setRegisterdate(date);
		studentAction.setStudent(student);
		String str=studentAction.StudentAdd();
		System.out.println(str);
	}
	//删除
	@Test
	public void StudentdeleteTest() throws UnsupportedEncodingException{
		Student student=studentDao.get(Student.class, 24);
//		Student student=new Student();
//	    student.setId(8);
//	    student.setStudentname("yui");
//	    student.setStudentNumber("1008");
//	    student.setStudentpassword("158");
	    studentAction.setStudent(student);
	    studentAction.Studentdelete();
	    
	}
	//更新
	@Test
	public void StudentupdateTest() throws UnsupportedEncodingException{
		Student student = new Student();
			student.setId(2);
			student.setStudentNumber("1002");
		student.setStudentname("日了狗DDD");
		student.setStudentpassword("妈个鸡	bbb");
//		 MyClass myClass=mc.get(MyClass.class, 2);
//		    student.setMyClass(myClass);
		studentAction.setStudent(student);
		studentAction.Studentupdate();
		
	}
	//分页
	@Test
	public void getStudentJsonByPageTest() throws UnsupportedEncodingException{
		studentAction.setPage(5);
		studentAction.setRows(10);
		String str = studentAction.getStudentJsonByPage();
		System.out.println(str);
	}
	@Test
	public void getstudent() throws UnsupportedEncodingException{
		
		Student student = new Student();
		student.setId(19);
		studentAction.setStudent(student);

//		student.setId(31);
		studentAction.getonesstudent();
		System.out.print(studentAction.getonesstudent());

	}
	
}
