package com.entor.test.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.TestPaperShiTiDao;
import com.entor.model.ShiTi;
import com.entor.model.TestPaper;
import com.entor.model.TestPaperShiTi;

public class TestPaperShiTiDaoTest {

	private ApplicationContext context;
	private TestPaperShiTiDao testPaperShiTiDao;
	@Before
	public void before(){
		context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		testPaperShiTiDao = (TestPaperShiTiDao)context.getBean("testPaperShiTiDaoImpl");
	}
	@Test
	public void testPaperShiTiAdd(){
		TestPaper testPaper = new TestPaper();
		testPaper.setId(4);
		ShiTi shiTi = new ShiTi();
		shiTi.setId(9);
		TestPaperShiTi testPeperShiTi = new TestPaperShiTi();
		testPeperShiTi.setShiTi(shiTi);
		testPeperShiTi.setTestPaper(testPaper);
		testPaperShiTiDao.save(testPeperShiTi);
	}
	@Test
	public void  testPaperShiTiDelete(){
		TestPaperShiTi testPeperShiTi = new TestPaperShiTi();
		testPeperShiTi.setId(2);
		testPaperShiTiDao.delete(testPeperShiTi);
	}
	@Test
	public void getTestPaperShiTi(){
		TestPaperShiTi testPaperShiTi 
		= testPaperShiTiDao.get(TestPaperShiTi.class, 3);
		System.out.println(testPaperShiTi);
	}
	@Test
	public void testPaperShiTiUpdate(){
		TestPaperShiTi testPaperShiTi 
		= testPaperShiTiDao.get(TestPaperShiTi.class, 3);
		
		ShiTi shiTi = new ShiTi();
		shiTi.setId(1);
	
		testPaperShiTi.setShiTi(shiTi);
		testPaperShiTiDao.update(testPaperShiTi);
	}
}
