package com.entor.dao.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entor.dao.BaseDao;

//T代表任意对象，K也差不多
@Repository
public class BaseDaoImpl<K, T> implements BaseDao<K, T>{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void delete(T entity) {
		//this.hibernateTemplate.getSessionFactory().getCurrentSession();
		this.hibernateTemplate.delete(entity);
	}

	public T get(Class cla, K id) {		
		
		return (T) this.hibernateTemplate.get(cla,(Serializable)id);		
	}

	public void save(T entity) {
		
		this.hibernateTemplate.save(entity);	
	}

	public void update(T entity) {
		this.hibernateTemplate.update(entity);
	}

}
