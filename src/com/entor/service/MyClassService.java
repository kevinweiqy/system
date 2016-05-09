package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.entor.model.MyClass;
import com.entor.model.QX_INFO;
import com.entor.model.Student;
import com.entor.utils.PageUtil;

public interface MyClassService {

	//增加
	public void addMyClass(MyClass myClass);
	
	//删除
	public void deleteMyClass(MyClass myClass);
	
	//更新
	public void updateMyClass(MyClass myClass);
	
	//获取一个
	public MyClass gatMyClass(int id) throws UnsupportedEncodingException;
	
	//分页的方法
	public InputStream getMyClassListJsonByPage(MyClass myClass,PageUtil pu) throws UnsupportedEncodingException;

	public MyClass gatMyClass_wo(int id) throws UnsupportedEncodingException ;

	
	
	
}
