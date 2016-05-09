package com.entor.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.entor.dao.StudentDao;

import com.entor.dao.RightorwrongDao;
import com.entor.dao.SelectDao;

import com.entor.dao.TestAnserDao;

import com.entor.dao.TestPaperDao;
import com.entor.model.Rightorwrong;
import com.entor.model.Student;

import com.entor.model.Select;

import com.entor.model.TestAnser;
import com.entor.model.TestPaper;
import com.entor.utils.PageUtil;

public class AnserTest {
	AbstractApplicationContext context;
	TestAnserDao tad;

	TestPaperDao testPaperDao;
	StudentDao studentDao;
	RightorwrongDao rightorwrongDao;
	SelectDao selectDao;

	@Before
	public void before() {
		// 先实例化spring容器
		context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		// 再从容器里面
		// 扫描名字默认为类名，首字母小写
		tad = (TestAnserDao) context.getBean("testAnserDaoImpl");

		testPaperDao = (TestPaperDao) context.getBean("testPaperDaoImpl");
		studentDao = (StudentDao) context.getBean("studentDaoImpl");
		rightorwrongDao = (RightorwrongDao) context
				.getBean("rightorwrongDaoImpl");
		selectDao = (SelectDao) context.getBean("selectDaoImpl");

	}

	@Test
	public void addtestanser() {
		TestAnser ta = new TestAnser();

		TestPaper testPaper = (TestPaper) testPaperDao.get(TestPaper.class, 5);
		System.out.println(testPaper);
		Rightorwrong rightorwrong = (Rightorwrong) rightorwrongDao.get(
				Rightorwrong.class, 21);
		Student student = (Student) studentDao.get(Student.class, 2);
		Select select = (Select) selectDao.get(Select.class, 1);

		ta.setTestPaper(testPaper);
		ta.setRightorwrong(rightorwrong);
		ta.setStudent(student);
		ta.setSelect(select);

		tad.save(ta);

	}

	@Test
	public void getTestAnserListByPage() {
		PageUtil pu = new PageUtil();
		pu.setPageNo(1);
		pu.setSize(4);
		List<TestAnser> list = tad.getTestAnserListByPage(null, pu);
		for (TestAnser ta : list) {
			System.out.println(ta.getRwAnswer() + "==" + ta.getSsAnswer());

		}
	}
}
