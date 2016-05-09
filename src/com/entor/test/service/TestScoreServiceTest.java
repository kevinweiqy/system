package com.entor.test.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.entor.dao.TestPaperDao;
import com.entor.dao.impl.TestPaperDaoImpl;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.service.StudentService;
import com.entor.service.TestPaperService;
import com.entor.service.TestScoreService;
import com.entor.service.impl.TestPaperServiceImpl;
import com.entor.utils.PageUtil;
@Service 
@Qualifier("testScoreServiceImpl")  //必须声明
public class TestScoreServiceTest {
	AbstractApplicationContext context;
	TestScoreService testScoreService;
	StudentService ss;
	
	

		@Before
		public void before(){
			//先实例化spring容器
			context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			//再从容器里面
			//扫描名字默认为类名，首字母小写
			testScoreService=(TestScoreService)context.getBean("testScoreServiceImpl");
		    ss=(StudentService) context.getBean("studentServiceImpl");
		}
		
		@Test
		public void addTestScore(){
			TestScore testScore=new TestScore();
			Student stu=ss.getStudent(5);			
			testScore.setExaminationdate(new Date());
			testScoreService.addTestScore(testScore);
		}
		@Test
		public void getTestScoreListByPage() throws UnsupportedEncodingException{
			PageUtil pu = new PageUtil();
			pu.setPageNo(1);
			pu.setSize(10);
			InputStream ts = testScoreService.getTestScoreListByPage(null, pu);
			System.out.println(ts);
		}
		
		

}
