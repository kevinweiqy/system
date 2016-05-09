package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.entor.model.Rightorwrong;
import com.entor.model.Select;
import com.entor.model.ShiTi;
import com.entor.utils.PageUtil;

public interface ShiTiService {

	//增加
	public void addShiTi(ShiTi shiTi);
	//修改
	public void updateShiTi(ShiTi shiTi);
	//删除
	public void deleteShiTi(ShiTi shiTi);
	//获取一个
	public Rightorwrong getRightorwrong(int id);
	public Select getSelect(int id);
	//根据条件查询并分页
	public InputStream getShiTiListByPage(ShiTi shiTi,PageUtil pu) throws UnsupportedEncodingException; 
	
}
