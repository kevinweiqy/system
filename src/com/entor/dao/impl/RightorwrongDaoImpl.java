package com.entor.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entor.dao.RightorwrongDao;
import com.entor.model.Rightorwrong;

@Repository("rightorwrongDaoImpl")
public class RightorwrongDaoImpl extends BaseDaoImpl<Integer,Rightorwrong> 
   implements RightorwrongDao{
	
	@Autowired
	private HibernateTemplate hibernateTemplate;

}
