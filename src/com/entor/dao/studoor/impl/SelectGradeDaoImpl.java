package com.entor.dao.studoor.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entor.dao.impl.BaseDaoImpl;
import com.entor.dao.studoor.SelectGradeDao;

import com.entor.model.Student;
import com.entor.model.TestScore;
@Repository("selectGradeDaoImpl")
public class SelectGradeDaoImpl extends BaseDaoImpl<Integer, TestScore>
     implements SelectGradeDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;
	


	/**
	 * 通过学生id查成绩
	 */
	public List<TestScore> selStuScore(int id) {
		// TODO Auto-generated method stub
		String hql="select ts  from  TestScore ts where ts.stu.id=?";
//		String hql="from  Student,TestScore  where id=:?";
		return this.hibernateTemplate.find(hql,new Object[]{id});
		
	}
	
	/**
	 * 通过试卷id查成绩
	 * 
	 */
	public List<TestScore> selTestPaperScore(int id){
		
		String hql="select ts from TestScore ts where ts.tp.id=?";
		return this.hibernateTemplate.find(hql,new Object[]{id});
	}
}
