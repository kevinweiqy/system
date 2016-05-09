package com.entor.test.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.model.Rightorwrong;
import com.entor.model.Select;
import com.entor.model.ShiTi;
import com.entor.service.ShiTiService;
import com.entor.utils.PageUtil;

public class ShiTiServiceTest {

	//spring容器对象
	AbstractApplicationContext context;
	ShiTiService shiTiService;
	@Before
	public void before(){
		//实例化spring容器
		context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		shiTiService = (ShiTiService)context.getBean("shiTiServiceImpl");
	}
	@Test
	public void addShiTi(){
//		Rightorwrong rightorwrong = new Rightorwrong();
//		rightorwrong.setNeirong("第6题");
//		rightorwrong.setSctupdate(new Date());
//		rightorwrong.setType(1);
//		rightorwrong.setAnswer(1);
//		rightorwrong.setShiti_code("006");
//		rightorwrong.setTeacherid(1);
		Select select = new Select();
		select.setShiti_code("007");
		select.setNeirong("第7题");
		select.setType(0);
		select.setResult1("A");
		select.setResult2("B");
		select.setResult3("C");
		select.setResult4("D");
		select.setSelectType(1);
		select.setAnswer("A");
		select.setSctupdate(new Date());
		select.setTeacherId(1);
		shiTiService.addShiTi(select);
	}
	@Test
	public void deleteShiTi(){
//		Rightorwrong rightorwrong = new Rightorwrong();
//		rightorwrong.setId(10);
		Select select = new Select();
		select.setId(11);
		shiTiService.deleteShiTi(select);
	}
	@Test
	public void getShiTi(){
//		ShiTi shiTi = shiTiDao.get(ShiTi.class, 2);
		int id=9;
		Select select = (Select)shiTiService.getSelect(id);
		System.out.println(select);
//		return shiTi;
	}
	@Test
	public void shiTiUpdate(){
		int id=9;
		Select select = (Select)shiTiService.getSelect(id);
		select.setAnswer("A");
//		Rightorwrong rightorwrong = (Rightorwrong)shiTiService.getShiTi(id);
//		rightorwrong.setAnswer(1);
		shiTiService.updateShiTi(select);
	}
	@Test
	public void getShiTiListByPageTest() throws UnsupportedEncodingException{
		PageUtil pu = new PageUtil();
		pu.setPageNo(1);
		pu.setSize(3);
		InputStream is = shiTiService.getShiTiListByPage(null, pu);
		System.out.println(is);
	}
}
