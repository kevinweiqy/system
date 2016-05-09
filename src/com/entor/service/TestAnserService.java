package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.entor.model.TestAnser;

import com.entor.utils.PageUtil;

public interface TestAnserService {
	//添加
	public void addTestAnser(TestAnser testAnser);
	//删除
	public void deleteTestAnser(TestAnser testAnser);
	//更新
	public void updateTestAnser(TestAnser testAnser);
	//取一个
	public TestAnser getTestAnser(TestAnser testAnser);
	
	//分页
	public InputStream getTestAnserListByPage(TestAnser testAnser,PageUtil pu) throws UnsupportedEncodingException;

}
