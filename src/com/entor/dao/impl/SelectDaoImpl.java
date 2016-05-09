package com.entor.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entor.dao.SelectDao;

import com.entor.model.Select;

@Repository("selectDaoImpl")
public class SelectDaoImpl extends BaseDaoImpl<Integer,Select> 
    implements SelectDao{
	      
	@Autowired
	private HibernateTemplate hibernateTemplate;

}
