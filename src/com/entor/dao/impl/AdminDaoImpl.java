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

import com.entor.dao.AdminDao;
import com.entor.model.Admin;
import com.entor.model.JS_XX;
import com.entor.utils.PageUtil;
@Repository("adminDaoImpl")
//教师dao实现类
public class AdminDaoImpl extends BaseDaoImpl<Integer,Admin>
implements AdminDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public List<Admin> getAdminList(final Admin admin) {
		// TODO Auto-generated method stub
		List<Admin> list= this.hibernateTemplate.execute(new HibernateCallback<List<Admin>>() {

			public List<Admin> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="from Admin where 1=1";
				  if(admin!=null){
				    	if(admin.getAdmin_name()!=null){
				    		hql=hql+" and admin_name like :name";
				    	}
				    	if(admin.getAdmin_number()!=null){
				    		hql=hql+" and admin_number = :number " ;
				    	}
				    }
				Query query=session.createQuery(hql);
				if(admin!=null){
					if(admin.getAdmin_name()!=null){
						query.setString("name","%"+admin.getAdmin_name()+"%"); 
					}
					if(admin.getAdmin_number()!=null){
						query.setString("number",admin.getAdmin_number());
					}
				}
				List<Admin> list=query.list(); 
				return list;
			}
		    
		   });
		return list;
		
		
	}
	//分页查询
	public List<Admin> getAdminlistByPage(final Admin admin,final PageUtil pu) {
		// TODO Auto-generated method stub
		List<Admin> list= this.hibernateTemplate.execute(new HibernateCallback<List<Admin>>() {

			public List<Admin> doInHibernate(Session session) throws HibernateException,
					SQLException {
				String hql="from Admin where 1=1";
				  if(admin!=null){
				    	if(admin.getAdmin_name()!=null){
				    		hql=hql+" and admin_name like :name";
				    	}
				    }
				Query query=session.createQuery(hql);
				if(admin!=null){
					if(admin.getAdmin_name()!=null){
						query.setString("name","%"+admin.getAdmin_name()+"%"); 
					}
				}
				List<Admin> list=query.setFirstResult((int)pu.getStartCursor()).setMaxResults(pu.getSize()).list(); 
				return list;
			}
		    
		   });
		return list;
	}

	//求总记录数
	public long getTotalRecords(Admin admin) {
		// TODO Auto-generated method stub
		 String hql="select count(id) from Admin where 1=1";
		    List<Object> argsList=new ArrayList<Object>();
		    if(admin!=null){
		    	if(admin.getAdmin_number()!=null){
		    		hql=hql+" and admin_number like ?";
		    		argsList.add("%"+admin.getAdmin_number()+"%");
		    	}
		    	if(admin.getAdmin_name()!=null){
		    		hql=hql+" and admin_name like ?";
		    		argsList.add("%"+admin.getAdmin_name()+"%");
		    	}
		    }
		    return  (Long) this.hibernateTemplate.find(hql,argsList.toArray()).get(0);
	}
	public boolean getAdmin(String loginName, String pwd) {
		// TODO Auto-generated method stub
		String hql="from Admin where admin_number = ? and admin_password = ?";
		List<Admin> admin = (List<Admin>) this.hibernateTemplate.find(hql,new Object[]{loginName,pwd});
		try {
			Admin a1 = admin.get(0);
			if(a1==null){
				return false;
			}else{
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}		
	}
	public Admin getAdminName(String loginName) {
		// TODO Auto-generated method stub
		String hql="from Admin where admin_number = ?";
		List<Admin> admin = (List<Admin>) this.hibernateTemplate.find(hql,new Object[]{loginName});
		return admin.get(0);
	}
	public List<Admin> getAdminList() {
		// TODO Auto-generated method stub
		List<Admin> list =this.hibernateTemplate.find("from Admin");
		return list;
	}
}
