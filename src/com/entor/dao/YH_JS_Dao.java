package com.entor.dao;

import java.util.List;

import com.entor.model.Admin;
import com.entor.model.JS_XX;
import com.entor.model.YH_JS;

public interface YH_JS_Dao extends BaseDao<Integer,YH_JS>{
	public List<YH_JS> getAllYH_JSList();
	public List<JS_XX> getJS_XXList(int id);
}
