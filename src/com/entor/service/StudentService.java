package com.entor.service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.entor.model.Student;
import com.entor.utils.PageUtil;



public interface StudentService {

	//添加
	public void studentAdd(Student student) ;
	
	//删除
	public void Studentdelete(Student student);
	
	//更新
	public void Studentupdate(Student student);
	
	//根据id查询一个商品
	public InputStream getonesStudent(int id) throws UnsupportedEncodingException;
	
	//根据条件查询得到一个商品列表
	public List<Student> getAllStudentList(Student student);
	
	//分页的方法
	public InputStream getStudentJsonByPage(Student student,PageUtil pu)throws UnsupportedEncodingException;
    
	public Student getStudent(int id);
}


