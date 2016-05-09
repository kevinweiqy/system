package com.entor.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entor.dao.YH_JS_Dao;
import com.entor.model.Admin;
import com.entor.model.JS_XX;
import com.entor.model.YH_JS;
@Repository("yH_JS_Dao_impl")
public class YH_JS_Dao_impl extends BaseDaoImpl <Integer,YH_JS>
implements YH_JS_Dao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	public List<YH_JS> getAllYH_JSList() {
		// TODO Auto-generated method stub
		List<YH_JS> list =this.hibernateTemplate.find("from YH_JS");
		return list;
	}
	//根据用户ID查角色
	public List<JS_XX> getJS_XXList(int id){
		List<JS_XX> list =this.hibernateTemplate.find("select jx from YH_JS yj,JS_XX jx where jx.id=yj.js_xx.id and  yj.admin.id = "+id);		
		for (JS_XX jsXX : list) {
			String xx = jsXX.getJs_name();
			System.out.println(xx);
		}
		return list;
	}
}
