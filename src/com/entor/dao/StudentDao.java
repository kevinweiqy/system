package com.entor.dao;

import java.util.List;

import com.entor.model.Student;
import com.entor.utils.PageUtil;

public interface StudentDao extends BaseDao<Integer,Student>{
      
	 //查询所有
	  public List<Student> getAllStudentList();
	  //按条件查询分页（物理）,用物理分页较好,其实这里还需要分页工具类的
	  public List<Student> getStudentListByPage(Student student,PageUtil pu);
	  //查询总的记录数
	  public long getTotalRecords(Student student);  
	  
	  public Student getStudent(String StudentNumber,String Studentpassword);
}