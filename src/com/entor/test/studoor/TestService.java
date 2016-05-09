package com.entor.test.studoor;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.model.ShiTi;
import com.entor.model.TestPaper;
import com.entor.service.studoor.SelectTestPaperServices;

public class TestService {
	AbstractApplicationContext context;
	SelectTestPaperServices selectTestPaperServices;
	 

		@Before
		public void before(){
			//先实例化spring容器
			context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			selectTestPaperServices=(SelectTestPaperServices)context.getBean("selectTestPaperServicesImpl");
		}
		
		@Test
		public void test() throws UnsupportedEncodingException{
			Map<String,List<ShiTi>> map1=selectTestPaperServices.getTestPaperShiTiList(5);
			String daAn=",1,0,1,0,1,0,1,0,1,0,1,0";
			Map<String,Object> map2= new HashMap<String, Object>();
			map2.put("daAn", daAn);
			map2.put("id", "5");
			TestPaper tp1=selectTestPaperServices.getTestPaperService(5);
			Map<String,TestPaper> map3=new HashMap<String, TestPaper>();
			map3.put("shijuan", tp1);
			selectTestPaperServices.addTestAnswer(map1, null, null);
		}
}
