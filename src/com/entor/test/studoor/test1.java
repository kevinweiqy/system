package com.entor.test.studoor;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.studoor.SelectTestPaperDao;
import com.entor.model.ShiTi;

public class test1 {
	 AbstractApplicationContext context;
	 SelectTestPaperDao selectTestPaperDao;
	 

		@Before
		public void before(){
			//先实例化spring容器
			context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			selectTestPaperDao=(SelectTestPaperDao)context.getBean("selectTestPaperDaoImpl");
		}
		
		@Test
		public void test(){
			List<ShiTi> list=selectTestPaperDao.getShiTiList(5);
			for (ShiTi shiTi : list) {
				System.out.println(shiTi.getType());
			}
			
			
		}
		
}
