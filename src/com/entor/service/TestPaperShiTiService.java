package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import com.entor.model.TestPaperShiTi;
import com.entor.utils.PageUtil;

public interface TestPaperShiTiService {

	//增加
	public void addTestPaperShiTi(TestPaperShiTi testPaperShiTi);
	//修改
	public void updateTestPaperShiTi(TestPaperShiTi testPaperShiTi);
	//删除
	public void deleteTestPaperShiTi(TestPaperShiTi testPaperShiTi);
	//获取一个
	public TestPaperShiTi getTestPaperShiTi(int id);
	//根据条件查询并分页
	public InputStream getTestPaperShiTiListByPage(TestPaperShiTi testPaperShiTi,PageUtil pu) throws UnsupportedEncodingException; 
	
}
