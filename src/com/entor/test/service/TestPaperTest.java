package com.entor.test.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.StudentDao;
import com.entor.dao.TestScoreDao;
import com.entor.model.MyClass;
import com.entor.model.ShiTi;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.service.MyClassService;
import com.entor.service.TestPaperService;
import com.entor.utils.PageUtil;

public class TestPaperTest {
	 AbstractApplicationContext context;
	 TestPaperService testPaperService;
	 StudentDao studentDao;
	 TestScoreDao testScoreDao;
	 
	 
		@Before
		public void before(){
			//先实例化spring容器
			context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			//再从容器里面
			//扫描名字默认为类名，首字母小写
			testPaperService=(TestPaperService)context.getBean("testPaperServiceImpl");
			studentDao=(StudentDao)context.getBean("studentDaoImpl");
			testScoreDao=(TestScoreDao)context.getBean("testScoreDaoImpl");
		}
		
		@Test
		public void testAddDefault(){
			TestPaper tp=new TestPaper();
			tp.setId(6);
			TestPaper tp1=testPaperService.getPaperService(tp);
			testPaperService.addDefaultPaperService(tp1);
		}
		
		@Test
		public void testquery() throws UnsupportedEncodingException{
			PageUtil pu=new PageUtil();
			pu.setPageNo(1);
			pu.setSize(50);
			testPaperService.getTestPaperListByPageService(null, pu);
		}
		
		@Test
		public void testqueryPanDuan() throws UnsupportedEncodingException{
			PageUtil pu=new PageUtil();
			pu.setPageNo(1);
			pu.setSize(50);
			ShiTi st=new ShiTi();
			st.setType(0);
		
			testPaperService.getShiTiService(st, pu);
		}
		
		
		@Test
		public void addStudentLists(){
			MyClass myClass = new MyClass();
			myClass.setClassNumber("classNumber2");
			TestPaper testPaper=new TestPaper();
			testPaper.setId(6);
			testPaperService.addTestStudents(testPaper, myClass);	
		}
		
		@Test
		public void getTestPaper(){
			
			
			
		}
		

}
