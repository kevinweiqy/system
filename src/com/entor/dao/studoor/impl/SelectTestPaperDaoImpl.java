package com.entor.dao.studoor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entor.dao.impl.BaseDaoImpl;
import com.entor.dao.studoor.SelectTestPaperDao;

import com.entor.model.ShiTi;
import com.entor.model.TestPaper;

@Repository("selectTestPaperDaoImpl")
public class SelectTestPaperDaoImpl extends BaseDaoImpl<Integer, ShiTi>
		implements SelectTestPaperDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<ShiTi> getShiTiList(int id) {
		String hqls = "select st from TestScore ts,TestPaperShiTi pt,ShiTi st where"
				+ " st.id=pt.shiTi.id and ts.tp.id = pt.testPaper.id and ts.stu.id=?";
		List<ShiTi> list = this.hibernateTemplate.find(hqls,
				new Object[] { id });
		return list;
	}

	public TestPaper getTestPaper(int id) {
		String hql= "select test from TestScore ts,TestPaper test where"
			+ " test.id=ts.tp.id and  ts.tp.id=?";
		List<TestPaper> list = this.hibernateTemplate.find(hql,new Object[] { id });
		return list.get(0);
	}

}
