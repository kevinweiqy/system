package com.entor.test;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.action.login.loginAction;
import com.entor.dao.AdminDao;
import com.entor.model.Admin;
import com.entor.service.AdminService;

public class AdminTest {
    AbstractApplicationContext context;
    AdminDao ad=null;
    AdminService as = null;
    loginAction la;
	@Before
	public void before(){
		//先实例化spring容器
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		//再从容器里面
		//扫描名字默认为类名，首字母小写
	    ad=(AdminDao)context.getBean("adminDaoImpl");
	    as=(AdminService) context.getBean("adminServiceImpl");
	    la=(loginAction) context.getBean("loginAction");
	}
//	@Test
//	public void adminAdd() {
//	    Admin admin=new Admin();
//	    admin.setAdmin_name("teacher2");
//	    admin.setAdmin_number("loginName2");
//	    admin.setAdmin_password("12345");
//	    admin.setStatus(1);
//	    ad.save(admin);	 
//   }
//	@Test
//	public void admindelete(){
//		 Admin admin=new Admin();
//		 	//admin.setId(77);
//		    admin.setAdmin_name("teacher444");
//		    admin.setAdmin_number("loginName4444");
//		    admin.setAdmin_password("123456");
//		    admin.setStatus(1);
//		 //   ad.delete(admin);
//		    //ad.update(admin);
//		  as.addAdmin(admin);  
//	}
//	@Test
//	public void booleanadmin(){
//	boolean fag =as.getBoolean("loginName3", "123456");	
//	System.out.println(fag);
//	}
//	
//	@Test
//	public void booleanadm() throws UnsupportedEncodingException{
//	String a=la.login();
//	System.out.println(a);
//	}
	
	@Test
	public void getqx() throws UnsupportedEncodingException{
		//as.getQxList("loginName3");
	}
}
