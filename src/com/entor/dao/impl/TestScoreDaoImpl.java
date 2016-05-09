package com.entor.dao.impl;


import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entor.dao.TestScoreDao;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.utils.PageUtil;
@Repository("testScoreDaoImpl")
public class TestScoreDaoImpl
extends BaseDaoImpl<Integer,TestScore> 
implements TestScoreDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public List<TestScore> getTestScoreListByPage( final TestScore testScore,
			final PageUtil pu) {
		
		List<TestScore> list= this.hibernateTemplate.execute(new HibernateCallback<List<TestScore>>() {

			public List<TestScore> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="from TestScore where 1=1";
				  if(testScore!=null){
					  if(testScore.getId()!=0){
						  hql=hql+" and id =?";
					  }
				    	if(testScore.getStu()!=null){
				    		hql=hql+" and student_id = :student_id";
				    	}
				    	if(testScore.getTp()!=null){
				    		hql=hql+" and testPaper_id = :testPaper_id";
				    	}
				    }
				Query query=session.createQuery(hql);
				if(testScore!=null){
					if(testScore.getId()!=0){
						query.setString("id","%"+testScore.getId()+"%");
						}
			    	if(testScore.getStu()!=null){
						query.setInteger("student_id",testScore.getStu().getId()); 
					}
			    	if(testScore.getTp()!=null){
						query.setInteger("testPaper_id",testScore.getTp().getId()); 
					}
				}
				List<TestScore> list=query.setFirstResult((int)pu.getStartCursor()).setMaxResults(pu.getSize()).list(); 
				return list;
			}
		    
		   });
		return list;
			
	}

	/* (non-Javadoc)获取总的记录数
	 * @see com.entor.dao.TestScoreDao#getTotalRecords(com.entor.model.TestScore)
	 */
	public long getTotalRecords(TestScore testScore) {
		
		return hibernateTemplate.execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				String hql = "select count(id) from TestScore";
				Query query =session.createQuery(hql);
				Long count = (Long)query.uniqueResult();
				return count;
			}			
		});
	}

	
	
	/**
	 * 根绝学生id和试卷id查找成绩表
	 */
	public TestScore getTestScore(TestPaper tp,Student stu) {
		String hql="select ts from TestScore ts where ts.tp.id=? and ts.stu.id=?";
		TestScore testScore=(TestScore) this.hibernateTemplate.find(hql,new Object[]{tp.getId(),stu.getId()}).get(0);	  
		return testScore;
			
	}

	public List<TestScore> getTestScores(Student stu) {
		String hql="select ts from TestScore ts where ts.stu.id=? ";
		List<TestScore> ts=(List<TestScore>) this.hibernateTemplate.find(hql,new Object[]{stu.getId()});	  
		return ts;
			
	}

	
	


}
