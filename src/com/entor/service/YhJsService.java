package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.entor.model.Admin;
import com.entor.model.JS_XX;
import com.entor.model.Student;
import com.entor.model.YH_JS;
//用户角色
public interface YhJsService {
	//添加
	public void YhJsAdd(YH_JS yhjs) throws Exception;
	
	//删除
	public void YhJsdelete(YH_JS yhjs);
	
	//更新
	public void YhJsupdate(YH_JS yhjs);
	//
	public InputStream getYH_JSList() throws UnsupportedEncodingException;
	public InputStream getJSList(int id) throws UnsupportedEncodingException;
}
