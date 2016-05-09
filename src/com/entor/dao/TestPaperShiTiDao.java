package com.entor.dao;

import java.util.List;

import com.entor.model.TestPaperShiTi;
import com.entor.utils.PageUtil;

public interface TestPaperShiTiDao extends BaseDao<Integer, TestPaperShiTi>{

	  //按条件查询分页（物理）,用物理分页较好,其实这里还需要分页工具类的
	  public List<TestPaperShiTi> getTestPeperShiTiListByPage(TestPaperShiTi peperShiTi,PageUtil pu);
	  //查询总的记录数
	  public long getTotalRecords(TestPaperShiTi testPeperShiTi); 
}
