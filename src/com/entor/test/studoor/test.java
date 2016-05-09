package com.entor.test.studoor;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.action.studoor.GetShiTiAction;
public class test {
	 AbstractApplicationContext context;
	 GetShiTiAction getShiTiAction;
	  
	 @Before
     public void before(){
		 context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		 getShiTiAction = (GetShiTiAction)context.getBean("getShiTiAction");
	 }
	 
	 @Test
	 public void getShiTi() throws UnsupportedEncodingException{
		 getShiTiAction.setId(5);
		 getShiTiAction.getTestPaperShiTiList();		 
	 }
}
