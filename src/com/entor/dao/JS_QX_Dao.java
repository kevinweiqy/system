package com.entor.dao;

import java.util.List;

import com.entor.model.JS_QX;
import com.entor.model.QX_INFO;



public interface JS_QX_Dao extends BaseDao<Integer,JS_QX>{
	//不做分页，只拿全部的
	public List<JS_QX> getAllJS_QXList();
	public List<QX_INFO> getQxList(int id);
}
