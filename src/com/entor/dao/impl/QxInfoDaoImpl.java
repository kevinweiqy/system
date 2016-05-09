package com.entor.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.entor.dao.AdminDao;
import com.entor.dao.QxInfoDao;
import com.entor.dao.YH_JS_Dao;


import com.entor.model.Admin;
import com.entor.model.JS_QX;
import com.entor.model.JS_XX;
import com.entor.model.QX_INFO;
import com.entor.model.YH_JS;

import com.entor.utils.PageUtil;
@Repository("qxInfoDaoImpl")
public class QxInfoDaoImpl extends BaseDaoImpl<Integer,QX_INFO>
implements QxInfoDao {

	@Autowired @Qualifier("yH_JS_Dao_impl")
	private YH_JS_Dao yhd;
	@Qualifier("adminDaoImpl")
	private AdminDao adminDao;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 拿所有权限信息
	 */
	@SuppressWarnings("unchecked")
	public List<QX_INFO> getAllQX_INFOList() {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.find("from QX_INFO ");
		
	}
	//分页查询
	public List<QX_INFO> getQX_INFOlistByPage(final QX_INFO qxINFO,final PageUtil pu) {
		// TODO Auto-generated method stub
		List<QX_INFO> list= this.hibernateTemplate.execute(new HibernateCallback<List<QX_INFO>>() {

			@SuppressWarnings("unchecked")
			public List<QX_INFO> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="from QX_INFO where 1=1";
//				  if(qxINFO!=null){
//				    	if(qxINFO.getQx_name()!=null){
//				    		hql=hql+" and qx_name like :qx_name";
//				    	}
//				    }
				Query query=session.createQuery(hql);
//				if(qxINFO!=null){
//					if(qxINFO.getQx_name()!=null){
//						query.setString("qx_name","%"+qxINFO.getQx_name()+"%"); 
//					}
//				}
				List<QX_INFO> list=query.setFirstResult((int)pu.getStartCursor()).setMaxResults(pu.getSize()).list(); 
				return list;
			}
		    
		   });
		return list;
	}
	//求总记录数
	public long getTotalRecords(QX_INFO qx) {
		// TODO Auto-generated method stub
		 String hql="select count(id) from QX_INFO where 1=1";
		    List<Object> argsList=new ArrayList<Object>();
		    return  (Long) this.hibernateTemplate.find(hql,argsList.toArray()).get(0);
	}			
	/**
	 * 把权限付给登录的用户
	 */
	public List<QX_INFO> getQX_INFOList(Admin admin) {
   	return null;	
	}
	/**
	 * 根据id拿用户权限
	 */
	public List<QX_INFO> getQX_INFOList(final int id) {
		
		String hqls = "select qx from QX_INFO qx,JS_QX jq,YH_JS yhjs where" +
				" qx.id=jq.qx_info.id and yhjs.js_xx.id = jq.js_xx.id and yhjs.admin.id=?";
		List<QX_INFO> list=this.hibernateTemplate.find(hqls,new Object[]{id});
		return list;
	}
}


