package com.entor.dao;

import java.util.List;
import com.entor.model.MyClass;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.utils.PageUtil;

public interface TestPaperDao extends BaseDao<Integer,TestPaper> {
	
	  //按条件查询分页（物理）,用物理分页较好,其实这里还需要分页工具类的
	  public List<TestPaper> getTestPaperlistByPage(TestPaper testPaper,PageUtil pu);
	  //查询总的记录数
	  public long getTotalRecords(TestPaper tp);  
	

		/**
		 * 通过班级编号找出班级对应的学生集合
		 */
		
	 public List<Student> getStudentList(String id);
	 
	     
	    /**
	     * 通过学生id找到试题id的集合
	     */
	    public List<TestPaper> getTestPaperList(int id);

}
