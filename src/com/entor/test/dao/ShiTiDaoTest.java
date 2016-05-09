package com.entor.test.dao;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.ShiTiDao;
import com.entor.model.Rightorwrong;
import com.entor.model.Select;
import com.entor.model.ShiTi;
import com.entor.utils.PageUtil;

public class ShiTiDaoTest {

	AbstractApplicationContext context;
	ShiTiDao shiTiDao;
	@Before
	public void before(){
		context=new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		shiTiDao=(ShiTiDao)context.getBean("shiTiDaoImpl");
	}
	@Test
	public void shiTiAdd(){
		for(int i=21;i<31;i++){
//		Select select = new Select();
//		select.setShiti_code("00"+i);
//		select.setNeirong("第"+i+"题");
//		select.setType(2);
//		select.setResult1("A");
//		select.setResult2("B");
//		select.setResult3("C");
//		select.setResult4("D");
//		select.setSelectType(2);
//		select.setAnswer("A");
//		select.setSctupdate(new Date());
//		select.setTeacherId(1);
		Rightorwrong rightorwrong = new Rightorwrong();
		rightorwrong.setNeirong("第"+i+"题");
		rightorwrong.setSctupdate(new Date());
		rightorwrong.setType(1);
		rightorwrong.setAnswer(1);
		rightorwrong.setShiti_code("00"+i);
		rightorwrong.setTeacherid(1);
		shiTiDao.save(rightorwrong);
		}
	}
	@Test
	public void shiTiDelete(){
//		Select select = new Select();
//		select.setId(10);
		Rightorwrong rightorwrong = new Rightorwrong();
		rightorwrong.setId(11);
		shiTiDao.delete(rightorwrong);
	}
	@Test
	public void getShiTi(){
//		ShiTi shiTi = shiTiDao.get(ShiTi.class, 2);
		Select select = (Select)shiTiDao.get(Select.class, 9);
		System.out.println(select);
//		return shiTi;
	}
	@Test
	public void shiTiUpdate(){
//		Select select = (Select)shiTiDao.get(Select.class, 9);
//		select.setAnswer("B");
		Rightorwrong rightorwrong = (Rightorwrong)shiTiDao.get(Rightorwrong.class, 2);
		rightorwrong.setAnswer(0);
		shiTiDao.update(rightorwrong);
	}
	@Test
	public void getShiTiListByPageTest(){
		PageUtil pu = new PageUtil();
		pu.setPageNo(1);
		pu.setSize(3);
		Rightorwrong rightorwrong = new Rightorwrong();
		List<ShiTi> list =
		shiTiDao.getSelectlistByPage(rightorwrong, pu);
		for (Object object : list) {
			System.out.println(object.equals(rightorwrong.getClass()));
		}
	}
	@Test
	public void getTotalRecords(){
		long num = shiTiDao.getTotalRecords(null);
		System.out.println(num);
	}
}
