package com.entor.test.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.action.shiti.ShiTiAction;
import com.entor.model.Rightorwrong;
import com.entor.model.Select;
import com.entor.service.ShiTiService;
import com.entor.utils.PageUtil;

public class ShiTiActionTest {

	//spring容器对象
	AbstractApplicationContext context;
	ShiTiAction shiTiAction;
	@Before
	public void before(){
		//实例化spring容器
		context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		shiTiAction = (ShiTiAction)context.getBean("shiTiAction");
	}
	@Test
	public void addShiTi() throws UnsupportedEncodingException{
		Rightorwrong rightorwrong = new Rightorwrong();
		rightorwrong.setNeirong("第10题");
		rightorwrong.setSctupdate(new Date());
		rightorwrong.setType(1);
		rightorwrong.setAnswer(1);
		rightorwrong.setShiti_code("010");
		rightorwrong.setTeacherid(1);
//		Select select = new Select();
//		select.setShiti_code("010");
//		select.setNeirong("第10题");
//		select.setType(0);
//		select.setResult1("A");
//		select.setResult2("B");
//		select.setResult3("C");
//		select.setResult4("D");
//		select.setSelectType(1);
//		select.setAnswer("A");
//		select.setSctupdate(new Date());
//		select.setTeacherId(1);
		shiTiAction.setRightorwrong(rightorwrong);
		shiTiAction.addShiTi();
	}
	@Test
	public void deleteShiTi() throws UnsupportedEncodingException{
//		Rightorwrong rightorwrong = new Rightorwrong();
//		rightorwrong.setId(10);
		Select select = new Select();
		select.setId(11);
		shiTiAction.deleteShiTi();
	}
	@Test
	public void getShiTi() throws UnsupportedEncodingException{
//		ShiTi shiTi = shiTiDao.get(ShiTi.class, 2);
//		Select select = new Select();
//		select.setId(13);
		Rightorwrong rightorwrong = new Rightorwrong();
		rightorwrong.setId(2);
		shiTiAction.setRightorwrong(rightorwrong);
		System.out.println(shiTiAction.getShiti());
//		return shiTi;
	}
	@Test
	public void shiTiUpdate() throws UnsupportedEncodingException{
//		Select select = new Select();
//		select.setId(11);
//		shiTiAction.getShiti();
//		select.setAnswer("A");
		Rightorwrong rightorwrong = new Rightorwrong();
		rightorwrong.setId(2);
		shiTiAction.setRightorwrong(rightorwrong);
		rightorwrong.setNeirong("222222");
		shiTiAction.updateShiTi();
	}
	@Test
	public void getShiTiListByPageTest() throws UnsupportedEncodingException{
	    shiTiAction.setPage(1);
	    shiTiAction.setRows(2);
	    Rightorwrong rightorwrong = new Rightorwrong();
	    rightorwrong.setType(1);
	    shiTiAction.setRightorwrong(rightorwrong);
	    shiTiAction.getShiTiListByPage();
		System.out.println(shiTiAction.getInputStream());
	}
	
}
