package com.entor.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.AdminDao;
import com.entor.dao.StudentDao;
import com.entor.dao.TestPaperDao;
import com.entor.dao.TestScoreDao;
import com.entor.model.Admin;
import com.entor.model.MyClass;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.utils.PageUtil;

public class TestPaperDaoTest {
	 AbstractApplicationContext context;
	 TestPaperDao testPaperDao;
	 TestScoreDao testScoreDao;
	 StudentDao studentDao;
	 AdminDao ad=null;
	 
		@Before
		public void before(){
			//先实例化spring容器
			context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			//再从容器里面
			//扫描名字默认为类名，首字母小写
			testPaperDao=(TestPaperDao)context.getBean("testPaperDaoImpl");
			ad=(AdminDao)context.getBean("adminDaoImpl");
			testScoreDao=(TestScoreDao)context.getBean("testScoreDaoImpl");
			studentDao=(StudentDao)context.getBean("studentDaoImpl");
		}
		
		@Test
		public void  addTest(){
			TestPaper testPaper=testPaperDao.get(TestPaper.class, 6);
			System.out.println(testPaper.getId());
//			Admin admin=ad.get(Admin.class,2);
//			TestPaper tp=new TestPaper();
//			Date date=new Date();
//			tp.setExamination_no(101);
//			tp.setPass_score(63);
//			tp.setTeacher(admin);
//			tp.setBeginTime(date);
//			tp.setEndTime(date);
//			tp.setSetupDate(date);
//			testPaperDao.save(tp);
		}
			
		@Test
		public void getTestPaperlistByPage(){
			PageUtil pu=new PageUtil();
			pu.setPageNo(1);
			pu.setSize(50);
			TestPaper tp=new TestPaper();
			tp.setExamination_no(2);
			List<TestPaper> list=testPaperDao.getTestPaperlistByPage(tp, pu);
		    for(TestPaper t:list){
		    	System.out.println(t.getPass_score());
		    }
		}
		

		/**
		 * 通过班级编号找出班级对应的学生集合
		 */		
		@Test
		public void addStudentLists(){
			MyClass myClass =new MyClass();
		    myClass.setClassNumber("classNumber2");
			List<Student> list=testPaperDao.getStudentList("classNumber2");
			TestScore testScore=new TestScore();
			for (Student student : list) {	
				testScore.setStu(student);
				testScoreDao.save(testScore);				
			}	
		}
		
	   
		
		
		

}
