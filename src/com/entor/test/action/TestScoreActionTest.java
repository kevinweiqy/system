package com.entor.test.action;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.action.testScore.TestScoreAction;
import com.entor.dao.StudentDao;
import com.entor.dao.TestPaperDao;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;

public class TestScoreActionTest {
	AbstractApplicationContext context;
	@Autowired @Qualifier("testScoreAction")
	TestScoreAction testScoreAction;
	@Autowired
	StudentDao studentDao;
	@Autowired
	TestPaperDao testPaperDao ;
	
	
	@Before
	public void before() {
		// 先十里湖spring容器
		context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		testScoreAction = (TestScoreAction) context.getBean("testScoreAction");
		studentDao=(StudentDao) context.getBean("studentDaoImpl");
		testPaperDao=(TestPaperDao) context.getBean("testPaperDaoImpl");
	}

	@Test
	public void getTestScoreJsonByPage() throws UnsupportedEncodingException{
		testScoreAction.setPage(1);
		testScoreAction.setRows(6);
		String str= testScoreAction.getTestScoreListByPage();
		System.out.println(str);
	}
	@Test
	public void addTestScore() throws UnsupportedEncodingException {
		TestScore testScore=new TestScore();
		
		Student student=studentDao.get(Student.class, 1);
		TestPaper testPaper=testPaperDao.get(TestPaper.class, 3);
		testScore.setStu(student);
		testScore.setTp(testPaper);
		testScore.setScore(59);
		testScore.setExaminationdate(new Date());
		testScoreAction.setTestScore(testScore);
	String	str=testScoreAction.addTestScore();
	System.out.println(str);
		
	}
	@Test
	public void get() throws UnsupportedEncodingException{
		TestScore testScore = new TestScore();
		testScore.setId(1);
		testScoreAction.setTestScore(testScore);
		testScoreAction.getTestScoreById();
	}
	

}
