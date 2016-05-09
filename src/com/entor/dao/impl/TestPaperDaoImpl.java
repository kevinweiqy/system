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

import com.entor.dao.TestPaperDao;
import com.entor.model.MyClass;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.utils.PageUtil;

@Repository("testPaperDaoImpl")
public class TestPaperDaoImpl
extends BaseDaoImpl<Integer, TestPaper>
implements TestPaperDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	

	/* (non-Javadoc)按条件查询分页（物理
	 * @see com.entor.dao.TestPaperDao#getTestPaperlistByPage(com.entor.model.TestPaper, com.entor.utils.PageUtil)
	 */
	public List<TestPaper> getTestPaperlistByPage(final TestPaper testPaper,
			final PageUtil pu) {
		List<TestPaper> list= this.hibernateTemplate.execute(new HibernateCallback<List<TestPaper>>() {

			public List<TestPaper> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="from TestPaper where 1=1";
				  if(testPaper!=null){
				    	if(testPaper.getExamination_no()!=0){
				    		hql=hql+" and examination_no like :examination_no";
				    	}
				    }
				Query query=session.createQuery(hql);
				if(testPaper!=null){
			    	if(testPaper.getExamination_no()!=0){
						query.setString("examination_no","%"+testPaper.getExamination_no()+"%"); 
					}
				}
				List<TestPaper> list=query.setFirstResult((int)pu.getStartCursor()).setMaxResults(pu.getSize()).list(); 
				return list;
			}
		    
		   });
		return list;
			
		
	}

	/* (non-Javadoc)查询总的记录数
	 * @see com.entor.dao.TestPaperDao#getTotalRecords()
	 */
	public long getTotalRecords(final TestPaper tp) {
		return hibernateTemplate.execute(new HibernateCallback<Long>() {
			public Long doInHibernate(Session session) throws HibernateException,
					SQLException {
				
				String hql = "select count(id) from TestPaper where 1=1";
				 if(tp!=null){
				    	if(tp.getExamination_no()!=0){
				    		hql=hql+" and examination_no like :examination_no";
				    	}
				    }
				Query query =session.createQuery(hql);
				if(tp!=null){
			    	if(tp.getExamination_no()!=0){
						query.setString("examination_no","%"+tp.getExamination_no()+"%"); 
					}
				}
				Long count = (Long)query.uniqueResult();
				return count;
			}			
		});
	}
	
	/**
	 * 通过班级编号找出班级对应的学生集合
	 */
	public List<Student> getStudentList(String id) {
		
		String hql="select sd from Student sd,MyClass mc where sd.myClass.id=mc.id and mc.classNumber=?";
		List<Student> list= this.hibernateTemplate.find(hql,new Object[]{id});
		return list;
		
	}
	
	
    /**
     * 通过学生id找试卷id的集合
     */
	public List<TestPaper> getTestPaperList(int id) {
		// TODO Auto-generated method stub
		
		String hql="select tp from TestPaper tp,TestScore ts,Student sd where" +
				"sd.id=ts.stu.id and tp.id=ts.tp.id and sd.id=?";
		List<TestPaper> list= this.hibernateTemplate.find(hql,new Object[]{id});
		
		return list;
	}
	
	
	

}
