package com.entor.test;


import java.util.List;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.entor.dao.JS_QX_Dao;
import com.entor.dao.JS_XX_Dao;
import com.entor.dao.QxInfoDao;

import com.entor.model.JS_QX;
import com.entor.model.JS_XX;
import com.entor.model.QX_INFO;


public class QxInfoDaoTest {
	// spring容器对象
	AbstractApplicationContext context;
	QxInfoDao qxInfoDao = null;
	JS_XX_Dao jsXXDao = null;
	JS_QX_Dao jsQXDao = null;

	@Before
	public void before() {
		// 先实例化spring容器
		context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		// 再从容器里面
		// 扫描名字默认为类名，首字母小写
		qxInfoDao = (QxInfoDao) context.getBean("qxInfoDaoImpl");
		jsXXDao = (JS_XX_Dao) context.getBean("jS_XX_Dao_impl");
		jsQXDao = (JS_QX_Dao) context.getBean("jS_QX_Dao_impl");
//		sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}

	/**
	 * 增加权限
	 */
	@Test
	public void addQX_INFO() {
		QX_INFO qxInfo = new QX_INFO();
		qxInfo.setQx_code(4);
		qxInfo.setQx_name("d4");		
		qxInfo.setQx_url("");
		qxInfo.setState(4);
		qxInfo.setMenu(4);
		qxInfo.setFather(qxInfo);
		

		qxInfoDao.save(qxInfo);

		JS_XX jsXX = new JS_XX();
		jsXX.setJs_name("5");
		jsXX.setJs_no("5");
		

		jsXXDao.save(jsXX);

		JS_QX jsQX = new JS_QX();
		jsQX.setQx_info(qxInfo);
		jsQX.setJs_xx(jsXX);

		jsQXDao.save(jsQX);

	}
	/**
	 * 删除权限
	 */
	@Test
	public void deleteQX_INFO(){
      QX_INFO qxINFO = new QX_INFO();
		qxINFO.setState(5);
		qxINFO.setQx_code(9);
		qxINFO.setQx_name("fds");
		qxInfoDao.delete(qxINFO);
	}
	
	/**
	 * 查询权限列表
	 */
	@Test
	public void selectAllQX_INFOList(){
		List<QX_INFO> list=qxInfoDao.getAllQX_INFOList();
		for(QX_INFO qx:list){			
			System.out.println(qx.getQx_name()+" "+qx.getQx_code());
			
	}
	
}
	
	

	/**
	 * 更新权限
	 */
	@Test
	public void UpdateQX_INFO(){
		QX_INFO qxINFO = (QX_INFO)qxInfoDao.get(QX_INFO.class,1);
		qxINFO.setQx_name("fx");
		qxInfoDao.update(qxINFO);
	}
	/**
	 * 通过用户id拿权限集合
	 *
	 */
	@Test
	public void getQX_INFOList(){		
		List<QX_INFO> list=qxInfoDao.getQX_INFOList(1);
		System.out.println(list.get(0).getQx_name());		
	}
	
}
