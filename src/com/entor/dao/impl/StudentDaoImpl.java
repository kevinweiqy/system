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

import com.entor.dao.StudentDao;
import com.entor.model.Student;
import com.entor.utils.PageUtil;


@Repository("studentDaoImpl")
public class StudentDaoImpl 
extends BaseDaoImpl<Integer, Student> implements StudentDao{
	
	@Autowired //注入对象
	public HibernateTemplate hibernateTemplate;
	
	//查询所有
	public List<Student> getAllStudentList() {
		//this.hibernateTemplate.find()里面写的是hql语句
		return this.hibernateTemplate
		.find("from Student");
	}
	
//	//条件查询
//	public List<Student> getStudentList(Student student) {
//		// TODO Auto-generated method stub
//		String hql = "from Studnet where 1=1 ";
//		//定义一个集合来放
//		List<Object> argsList = new ArrayList<Object>();
//		if(student!=null){
//			if(student.getStudentname()!=null){
//				hql = hql + "and studentname like ?";
//				argsList.add("%"+student.getStudentname()+"%");
//			}
//			if(student.getStudentNumber()!=null){
//				hql = hql + "and studentNumber like ?";
//				argsList.add("%"+student.getStudentNumber()+"%");
//			}
//		}
//		//集合转数组
//		Object[] objs = argsList.toArray();
//		return this.hibernateTemplate.
//		find(hql,objs);
//	}
	
	//条件查询（带分页）
	public List<Student> getStudentListByPage(final Student student,final PageUtil pu) {
		//用匿名内部类,并实现里面的方法,这里的泛型=匿名内部类里面的类型+泛型,如内部类的类型+泛型是List<Goods>,那么它的泛型就是List<Goods>
		List<Student> list = this.hibernateTemplate.execute(new HibernateCallback<List<Student>>() {
			//这里传一个session进来，直接就可以用，千万不要再去获取一个
			public List<Student> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql = "from Student where 1=1";
				//要再匿名内部类里面用goods，在上面必须把goods声明称final类型的
				if(student!=null){
					if(student.getStudentname()!=null){
						hql = hql + "and studentname like :studentname";
						
					}
					if(student.getStudentNumber()!=null){
						hql = hql + "and studentNumber like :studentNumber";
						
					}
				}
				
				Query query = session.createQuery(hql);
				if(student!=null){
					if(student.getStudentname()!=null){
						query.setString("studentname", "%"+student.getStudentname()+"%");
					}
					if(student.getStudentNumber()!=null){
						query.setString("studentNumber", "%"+student.getStudentNumber()+"%");
					}
				}
				//setFirstResult()里面传的是开始的位置数，setMaxResults()里面传的是每页的记录数
				return query.setFirstResult((int)pu.getStartCursor())
				.setMaxResults(pu.getSize()).list();
 
			}
		
		});
		return list;
	}

	//获取总的记录数
	public long getTotalRecords(Student student) {
		String hql = "select count(id) from Student where 1=1 ";
		//定义一个集合来放
		List<Object> argsList = new ArrayList<Object>();
		if(student!=null){
			if(student.getStudentname()!=null){
				hql = hql + "and studentname like ?";
				argsList.add("%"+student.getStudentname()+"%");
			}
			if(student.getStudentNumber()!=null){
				hql = hql + "and studentNumber like ?";
				argsList.add("%"+student.getStudentNumber()+"%");
			}
		}
		//集合转数组
		Object[] objs = argsList.toArray();
		//因为这里获得的集合里面只有一个值，所以我们直接取第一个就可以了
		return (Long)this.hibernateTemplate.
		find(hql,objs).get(0);
	}

	public Student getStudent(String StudentNumber, String Studentpassword) {
		
		String hql = "from Student where studentNumber=? and studentpassword=?";
		List<Student> list=(List<Student>) this.hibernateTemplate.
		find(hql,new Object[]{StudentNumber,Studentpassword});			
	    Student s = list.get(0);
	    return s;
	}
	
}
