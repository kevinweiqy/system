package com.entor.test.action;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.service.studoor.SelectTestPaperServices;


public class TestKaoShi {
	AbstractApplicationContext context;
	@Autowired @Qualifier("selectTestPaperServicesImpl")
	SelectTestPaperServices sps;

	
	
	@Before
	public void before() {
		// 先十里湖spring容器
		context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		sps = (SelectTestPaperServices) context.getBean("selectTestPaperServicesImpl");
	}
	@Test
	public void testPanDuan(){
		sps.getTestPaperShiTiList(5);
	}
	
	
	@Test
	public void testshijuan(){
		sps.getTestPaperService(5);
	}
	
	
	
}
