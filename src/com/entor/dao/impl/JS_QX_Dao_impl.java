package com.entor.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entor.dao.JS_QX_Dao;
import com.entor.dao.JS_XX_Dao;
import com.entor.model.JS_QX;
import com.entor.model.JS_XX;
import com.entor.model.QX_INFO;

@Repository("jS_QX_Dao_impl")
public class JS_QX_Dao_impl extends BaseDaoImpl<Integer,JS_QX> implements JS_QX_Dao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public List<JS_QX> getAllJS_QXList() {		
		List<JS_QX> list =this.hibernateTemplate.find("from JS_QX");
		return list;
	}
	//根据角色ID查权限
	public List<QX_INFO> getQxList(int id){
		List<QX_INFO> list =this.hibernateTemplate.find("select qx from JS_QX qj,QX_INFO qx where qx.id=qj.qx_info.id and  qj.js_xx.id = "+id);		
		return list;
	}
}
