package com.entor.dao.studoor;


import java.util.List;

import com.entor.dao.BaseDao;

import com.entor.model.ShiTi;
import com.entor.model.Student;
import com.entor.model.TestPaper;


public interface SelectTestPaperDao extends BaseDao<Integer,ShiTi>{
	
	
	/**
	 * 通过学生id找试题的集合
	 */
	
	public List<ShiTi> getShiTiList(int id);
	
	/**
	 * 通过学生id找到没有成绩的试卷,
	 */
	public TestPaper getTestPaper(int id);

}
