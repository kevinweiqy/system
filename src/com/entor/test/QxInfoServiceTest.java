package com.entor.test;

import java.io.UnsupportedEncodingException;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.QxInfoDao;
import com.entor.model.QX_INFO;

import com.entor.service.QX_INFOService;

public class QxInfoServiceTest {
	// spring容器对象
	AbstractApplicationContext context;
	QX_INFOService qxINFOService = null;
	QxInfoDao qxInfoDao = null;

	@Before
	public void before() {
		// 先实例化spring容器
		context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		qxINFOService = (QX_INFOService) context.getBean("QX_INFOServiceImpl");
		qxInfoDao = (QxInfoDao) context.getBean("qxInfoDaoImpl");
	}

	/**
	 * 增加
	 * 
	 * @throws Exception
	 */
	@Test
	public void addQX_INFOTest() throws Exception {
		QX_INFO qxINFO = new QX_INFO();
		qxINFO.setState(9);
		qxINFO.setQx_code(9);
		qxINFO.setQx_name("f84");
		qxINFOService.addQxINFO(qxINFO);
	}

	// 删除
	@Test
	public void deleteQX_INFOTest() {
		QX_INFO qxINFO = new QX_INFO();
		qxINFO.setId(4);
		qxINFO.setState(5);
		qxINFO.setQx_code(9);
		qxINFO.setQx_name("fds");
		qxINFOService.deleteQxINFO(qxINFO);
	}


	//根据id查权限信息
	@Test
	public void getQX_INFO(){
		QX_INFO qxINFO =(QX_INFO)qxInfoDao.get(QX_INFO.class, 13);
		
		System.out.println(qxINFO);
	}
	
	/**
	 * 查询权限所有信息
	 */
	@Test
	public void getAllQX_INFOList() {
		List<QX_INFO> list = qxInfoDao.getAllQX_INFOList();
		for (QX_INFO qx : list) {
			System.out.println(qx.getQx_name() + " " + qx.getQx_code());

		}
	}
	
	
	/**
	 * 更新
	 */
	@Test
	public void UpdateQX_INFO() {
		QX_INFO qxINFO = (QX_INFO) qxInfoDao.get(QX_INFO.class, 6);
		qxINFO.setQx_code(8);
		qxINFOService.updateQxINFO(qxINFO);
	}
	/**
	 * 测试
	 * @throws UnsupportedEncodingException 
	 * */
	@Test
	public void all() throws UnsupportedEncodingException {
		qxINFOService.getAllQX_INFOList();
	}
}
