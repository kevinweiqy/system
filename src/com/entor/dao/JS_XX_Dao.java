package com.entor.dao;

import java.util.List;

import com.entor.model.JS_XX;
import com.entor.utils.PageUtil;


public interface JS_XX_Dao extends BaseDao<Integer,JS_XX>{
	
	public List<JS_XX> getAllJS_XXList();
	public List<JS_XX> getAllJS_XXList(JS_XX jsxx,PageUtil pu);
	public long getTotalRecords(JS_XX jsxx);
}
