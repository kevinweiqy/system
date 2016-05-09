package com.entor.dao;

import java.util.List;

import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.utils.PageUtil;

public interface TestScoreDao extends BaseDao<Integer, TestScore> {
	
	 //按条件查询分页（物理）,用物理分页较好,其实这里还需要分页工具类的
	  public List<TestScore> getTestScoreListByPage(TestScore testScore,PageUtil pu);
	  //查询总的记录数
	  public long getTotalRecords(TestScore testScore);
	  
	  //查询考试成绩
	  public TestScore getTestScore(TestPaper tp,Student stu);

	  //查询某个学生的成绩
	  public List<TestScore> getTestScores(Student stu);

}
