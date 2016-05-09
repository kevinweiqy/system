package com.entor.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entor.dao.TestPaperShiTiDao;
import com.entor.model.TestPaperShiTi;
import com.entor.utils.PageUtil;
@Repository
public class TestPaperShiTiDaoImpl extends BaseDaoImpl<Integer, TestPaperShiTi>
implements TestPaperShiTiDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<TestPaperShiTi> getTestPeperShiTiListByPage(
			final TestPaperShiTi testPaperShiTi,final PageUtil pu) {
		// TODO Auto-generated method stub
		List<TestPaperShiTi> list =
			this.hibernateTemplate.execute(new HibernateCallback<List<TestPaperShiTi>>() {
				public List<TestPaperShiTi> doInHibernate(Session session)
						throws HibernateException, SQLException {
					// TODO Auto-generated method stub
					String hql = "from TestPaperShiTi where 1=1";
					if(testPaperShiTi!=null){
						if(testPaperShiTi.getId()!=0){
							hql = hql+" and id=?";
						}
					}
					Query query = session.createQuery(hql);
					if(testPaperShiTi!=null){
						if(testPaperShiTi.getId()!=0){
							query.setInteger("id", testPaperShiTi.getId());
						}
					}
					return query.setFirstResult((int)pu.getStartCursor()).setMaxResults(pu.getSize()).list();
				}
			});
		return list;
	}

	public long getTotalRecords(TestPaperShiTi testPeperShiTi) {
		// TODO Auto-generated method stub
		String hql = "select count(id) from TestPaperShiTi where 1=1";
		List<Object> list = new ArrayList<Object>();
		if(testPeperShiTi!=null){
			if(testPeperShiTi.getId()!=0){
				hql = hql+" and id=?";
				list.add(testPeperShiTi.getId());
			}
		}
		Object[] obj=list.toArray();
		return (Long)this.hibernateTemplate
		.find(hql,obj).get(0);
	}

}
