package com.entor.dao;

import java.util.List;

import com.entor.model.ShiTi;
import com.entor.utils.PageUtil;

public interface ShiTiDao extends BaseDao<Integer, ShiTi>{
	
	 //按条件查询分页（物理）,用物理分页较好,其实这里还需要分页工具类的
	public List<ShiTi> getSelectlistByPage(ShiTi shiTi,PageUtil pu);
	//查询总的记录数
	public long getTotalRecords(ShiTi shiTi);
//	//按照条件查询多选题
//	public List<ShiTi> getSelectslistByPage(ShiTi shiTi,PageUtil pu);
	
}
