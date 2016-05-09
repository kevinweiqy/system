package com.entor.dao;

import java.util.List;

import com.entor.model.Admin;
import com.entor.model.TestAnser;
import com.entor.utils.PageUtil;

public interface TestAnserDao extends BaseDao<Integer,TestAnser>{
	//按条件查询分页（物理）,用物理分页较好,其实这里还需要分页工具类的
	  public List<TestAnser> getTestAnserListByPage(TestAnser ta,PageUtil pu);
	  //查询总的记录数
	  public long getTotalRecords(TestAnser ta); 
	  
	  public long getTotal(TestAnser ta);
	 

}
