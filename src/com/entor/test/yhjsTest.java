package com.entor.test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.AdminDao;
import com.entor.dao.JS_XX_Dao;
import com.entor.dao.YH_JS_Dao;
import com.entor.model.Admin;
import com.entor.model.JS_XX;
import com.entor.model.YH_JS;
import com.entor.service.AdminService;
import com.entor.service.YhJsService;

public class yhjsTest {
    AbstractApplicationContext context;
    YH_JS_Dao yd=null;
    AdminDao ad=null;
    JS_XX_Dao jx = null;
    YhJsService js= null;
	@Before
	public void before(){
		//先实例化spring容器
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		//再从容器里面
		//扫描名字默认为类名，首字母小写
		ad=(AdminDao)context.getBean("adminDaoImpl");
		jx=(JS_XX_Dao)context.getBean("jS_XX_Dao_impl");
		yd=(YH_JS_Dao)context.getBean("yH_JS_Dao_impl");
		js=(YhJsService)context.getBean("YhJsServiceImpl");
	}
	@Test
	public void admindelete(){
		Admin admin=new Admin();
		 	admin.setId(4);
		    admin.setAdmin_name("teacher4");
		    admin.setAdmin_number("loginName4");
		    admin.setAdmin_password("123456");
		    admin.setStatus(1);
		    ad.save(admin);   
		JS_XX jxx = new JS_XX();
			jxx.setJs_name("jsname2");
			jxx.setJs_no("jx002");
			jxx.setJs_status(1);
			jxx.setJs_detail("描述2");
			jx.save(jxx);
			YH_JS yj = new YH_JS();
			yj.setAdmin(admin);
			yj.setJs_xx(jxx);
			yd.save(yj);			
	}
	@Test
	public void list() throws UnsupportedEncodingException{
		//yd.getJS_XXList(1);
		//js.getJSList(1);
		System.out.println(yd.getJS_XXList(1));
	}
}
