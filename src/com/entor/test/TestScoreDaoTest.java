package com.entor.test;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.entor.dao.TestScoreDao;

import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.utils.PageUtil;

public class TestScoreDaoTest {
	AbstractApplicationContext context;
	TestScoreDao testScoreDao;

		@Before
		public void before(){
			//先实例化spring容器
			context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			//再从容器里面
			//扫描名字默认为类名，首字母小写
			testScoreDao=(TestScoreDao)context.getBean("testScoreDaoImpl");
		}
		
		@Test
		public void addTestScore(){
			TestScore ts=new TestScore();
			Student stu=new Student();
			TestPaper tp=new TestPaper();
			ts.setStu(stu);
			ts.setTp(tp);
			ts.setScore(22);
			ts.setExaminationdate(new Date());
			testScoreDao.save(ts);
		}
		@Test
		public void getTotalRecords(){
		long num=testScoreDao.getTotalRecords(null);
		System.out.println(num);
		
		}
		@Test
		public void getTestScoreListByPage(){
//			TestScore testScore = new TestScore();
//			testScore.setScore(2);
			PageUtil pu = new PageUtil();
			pu.setPageNo(1);
			pu.setSize(4);
			List<TestScore> list = 
				testScoreDao.getTestScoreListByPage(null, pu);
			for (TestScore testScore2 : list) {
				System.out.println(testScore2.getScore()+"---"+testScore2.getExaminationdate());
			}
		}

}
