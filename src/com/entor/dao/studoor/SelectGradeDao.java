package com.entor.dao.studoor;

import java.util.List;

import com.entor.dao.BaseDao;

import com.entor.model.TestScore;

public interface SelectGradeDao  extends BaseDao<Integer,TestScore>{
	
	/**
	 * 查询学生成绩
	 * @param id
	 */
	public List<TestScore> selStuScore(int id);
	
	
	/**
	 * 通过试卷的id成绩成绩
	 * 
	 */
	public List<TestScore> selTestPaperScore(int id);

}
