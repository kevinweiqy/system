package com.entor.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.AdminDao;
import com.entor.dao.JS_XX_Dao;
import com.entor.model.Admin;
import com.entor.model.JS_XX;
import com.entor.service.AdminService;

public class jsxxTest {
	 AbstractApplicationContext context;
	 JS_XX_Dao jx = null;
		@Before
		public void before(){
			//先实例化spring容器
			context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
			//再从容器里面
			//扫描名字默认为类名，首字母小写
			jx=(JS_XX_Dao)context.getBean("jS_XX_Dao_impl");
		}
		@Test
		public void admindelete(){
			JS_XX jxx = new JS_XX();
			jxx.setJs_name("jsname90");
			jxx.setJs_no("jx010");
			jxx.setJs_status(1);
			jxx.setJs_detail("描述88");
			jx.save(jxx);
		}
}
