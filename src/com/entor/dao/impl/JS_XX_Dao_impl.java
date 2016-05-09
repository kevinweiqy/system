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

import com.entor.dao.JS_XX_Dao;
import com.entor.model.JS_XX;
import com.entor.utils.PageUtil;

@Repository("jS_XX_Dao_impl")
public class JS_XX_Dao_impl extends BaseDaoImpl<Integer,JS_XX> 
implements JS_XX_Dao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public List<JS_XX> getAllJS_XXList() {
		// TODO Auto-generated method stub
		List<JS_XX> list =this.hibernateTemplate.find("from JS_XX");
		return list;
	}
	//通过名称查询
	public List<JS_XX> getAllJS_XXList(final JS_XX jsxx,final PageUtil pu) {
		// TODO Auto-generated method stub
		final List<JS_XX> list = this.hibernateTemplate.execute(new HibernateCallback<List<JS_XX>>(){

			public List<JS_XX> doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql="from JS_XX where 1=1";
				if(jsxx!=null){
			    	if(jsxx.getJs_name()!=null){
			    		hql=hql+" and js_name like :name";
			    	}
				}
				Query query=session.createQuery(hql);
				if(jsxx!=null){
			    	if(jsxx.getJs_name()!=null){
			    		query.setString("name","%"+jsxx.getJs_name()+"%"); 
			    	}
				}
				List<JS_XX> list = query.setFirstResult((int)pu.getStartCursor()).setMaxResults(pu.getSize()).list();
				return list;
			}
		});
		return list;
	}
	public long getTotalRecords(JS_XX jsxx) {
		// TODO Auto-generated method stub		
		 String hql="select count(id) from JS_XX where 1=1";
		    List<Object> argsList=new ArrayList<Object>();
		    return  (Long) this.hibernateTemplate.find(hql,argsList.toArray()).get(0);
	}	
}
