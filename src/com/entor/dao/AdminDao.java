package com.entor.dao;

import java.util.List;

import com.entor.model.Admin;
import com.entor.utils.PageUtil;

public interface AdminDao extends BaseDao<Integer,Admin>{
	  //按条件查询分页（物理）,用物理分页较好,其实这里还需要分页工具类的
	  public List<Admin> getAdminlistByPage(Admin admin,PageUtil pu);
	  //查询总的记录数
	  public long getTotalRecords(Admin admin);
	  public List<Admin> getAdminList(Admin admin);
	  public List<Admin> getAdminList();
	  public boolean getAdmin(String loginName,String pwd);
	  public Admin getAdminName(String loginName);
}
