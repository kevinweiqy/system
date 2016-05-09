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


import com.entor.dao.MyClassDao;
import com.entor.model.MyClass;
import com.entor.model.Student;
import com.entor.utils.PageUtil;

@Repository("myClassDaoImpl")
public class MyClassDaoImpl 
extends BaseDaoImpl<Integer,MyClass> 
implements MyClassDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 分页查询方法
	 */
	public List<MyClass> getMyClassListByPage
	(final MyClass myClass,final PageUtil pu) {
		// TODO Auto-generated method stub
		List<MyClass> list = this.hibernateTemplate
		.execute(new HibernateCallback<List<MyClass>>() {

			public List<MyClass> doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql="from MyClass where 1=1";
				if(myClass != null){
					
					if(myClass.getClassNumber() != null){
						hql= hql+" and classNumber like :classNumber";
					}
					
				    if(myClass.getClassName() != null){
					    hql=hql+" and className like :className";
				    }
				}
				Query query = session.createQuery(hql);
				if (myClass != null) {
					if (myClass.getClassNumber() != null) {
						query.setString("classNumber", "%" + myClass.getClassNumber()+ "%");
					}
					if (myClass.getClassName() != null) {
						query.setString("className", "%" + myClass.getClassName()+ "%");
					}
				}
				return query.setFirstResult((int)pu.getStartCursor()).
				setMaxResults(pu.getSize()).list();
			}
		});
		return list;
	}

	/**
	 *查询总的记录数
	 */
	public long getTotolRecords(MyClass myClass) {
		// TODO Auto-generated method stub
		String hql = "select count(id) from MyClass where 1=1 ";
		List<Object> argsList = new ArrayList<Object>();
		if(myClass != null){
			
			if(myClass.getClassNumber() != null){
				hql= hql+" and ClassNumber like ?";
				argsList.add("%" + myClass.getClassNumber() + "%");
			}
			
		    if(myClass.getClassName() != null){
			    hql=hql+" and ClassName like ?";
			    argsList.add("%" + myClass.getClassName() + "%");
		    }
		}
		Object[] objs = argsList.toArray();
		
		return (Long) this.hibernateTemplate.find(hql, objs).get(0);
	}

	
	

	
}
