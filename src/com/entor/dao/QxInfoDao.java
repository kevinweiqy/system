package com.entor.dao;

import java.util.List;


import com.entor.model.Admin;
import com.entor.model.QX_INFO;
import com.entor.utils.PageUtil;

public interface QxInfoDao extends BaseDao<Integer,QX_INFO>{

	 //按条件查询分页（物理）,用物理分页较好,其实这里还需要分页工具类的
	  public List<QX_INFO> getQX_INFOlistByPage(QX_INFO qxINFO,PageUtil pu);
	  //查询总的记录数
	  public long getTotalRecords(QX_INFO qxx); 
	  
	  
	 
		/*
		 * 查询所有的权限信息
		 */
		public List<QX_INFO> getAllQX_INFOList();
		
		
		/**
		 * 拿登录的用户名
		 */
		public List<QX_INFO> getQX_INFOList(Admin admin);
		
		
		/**
		 * 通过用户id拿权限集合
		 */
		public  List<QX_INFO> getQX_INFOList(int id);
	
}
