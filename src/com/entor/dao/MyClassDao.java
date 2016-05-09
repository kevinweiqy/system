package com.entor.dao;

import java.util.List;

import com.entor.model.MyClass;
import com.entor.model.Student;
import com.entor.utils.PageUtil;

public interface MyClassDao extends BaseDao<Integer,MyClass>{
	/**
	 * 分页查询方法
	 */
	public List<MyClass> getMyClassListByPage(MyClass myClass,PageUtil pu);
	
	/**
	 * 查询总的记录数
	 */
	public long getTotolRecords(MyClass myClass);
	
	
	
}
