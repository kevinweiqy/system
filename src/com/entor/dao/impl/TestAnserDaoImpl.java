package com.entor.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.entor.dao.TestAnserDao;
import com.entor.model.TestAnser;
import com.entor.utils.PageUtil;


@Repository
public class TestAnserDaoImpl extends BaseDaoImpl<Integer,TestAnser>
implements TestAnserDao{
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public long getTotalRecords(TestAnser ta) {
		 String hql="select count(id) from TestAnser where 1=1";
		    List<Object> argsList=new ArrayList<Object>();
		    if(ta!=null){
		    	if(ta.getSsAnswer()>=0){
		    		hql=hql+" and ssAnswer=?";
		    		argsList.add(ta.getSsAnswer());
		    	}
		    	if(ta.getRwAnswer()>=0){
		    		hql=hql+" and rwAnswer=?";
		    		argsList.add(ta.getRwAnswer());
		    	}
		    }
		    return  (Long) this.hibernateTemplate.find(hql,argsList.toArray()).get(0);
	}

	public List<TestAnser> getTestAnserListByPage(final TestAnser testAnser, final PageUtil pu) {
		List<TestAnser> list= this.hibernateTemplate.execute(new HibernateCallback<List<TestAnser>>() {

			public List<TestAnser> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="select ta from TestAnser ta where 1=1";
				  if(testAnser!=null){
				    	if(testAnser.getId()!=0){
				    		hql=hql+" and ta.id=?";
				    	}
				    	if(testAnser.getStudent()!=null&&testAnser.getTestPaper()!=null){
				    		hql=hql+" and ta.student.id = :st"+" and ta.testPaper.id = :tp";
				    	}
				    }
				Query query=session.createQuery(hql);
				if(testAnser!=null){
			    	if(testAnser.getId()!=0){
						 query.setInteger("id",testAnser.getId()); 
					}
			    	if(testAnser.getStudent()!=null&&testAnser.getTestPaper()!=null){
			    		query.setInteger("st", testAnser.getStudent().getId());
			    		query.setInteger("tp", testAnser.getTestPaper().getId());
			    	}
				}
				List<TestAnser> list1=query.setFirstResult((int)pu.getStartCursor()).setMaxResults(pu.getSize()).list(); 
				return list1;
			}
		    
		   });
		return list;
	}
	
	public long getTotal(TestAnser ta) {
		 String hql="select count(id) from TestAnser ta where 1=1";
		    List<Object> argsList=new ArrayList<Object>();
		    if(ta!=null){
		    	if(ta.getStudent()!=null&&ta.getTestPaper()!=null){
		    		hql=hql+" and ta.student.id=?"+" and ta.testPaper.id =?";
		    		argsList.add(0, ta.getStudent().getId());
		    		argsList.add(1, ta.getTestPaper().getId());
		    	}
		    }
		    return  (Long) this.hibernateTemplate.find(hql,argsList.toArray()).get(0);
	}
	
	

}
