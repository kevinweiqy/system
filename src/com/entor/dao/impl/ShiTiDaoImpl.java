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

import com.entor.dao.ShiTiDao;
import com.entor.model.Rightorwrong;
import com.entor.model.Select;
import com.entor.model.ShiTi;
import com.entor.utils.PageUtil;
@Repository
public class ShiTiDaoImpl extends BaseDaoImpl<Integer, ShiTi>
implements ShiTiDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	 
	public List<ShiTi> getSelectlistByPage(final ShiTi shiTi, final PageUtil pu) {
		// TODO Auto-generated method stub
		List<ShiTi> list = this.hibernateTemplate.execute(new HibernateCallback<List<ShiTi>>() {

			public List<ShiTi> doInHibernate(Session session)
					throws HibernateException, SQLException {
				// TODO Auto-generated method stub
				String hql = "from ShiTi where 1=1";
				if(shiTi!=null){
				if(shiTi.getType()==1){
					hql = hql+" and type=1";
					if(shiTi.getNeirong()!=null){
						hql = hql+" and neirong like :neirong";
					}
					if(shiTi.getShiti_code()!=null){
						hql = hql+" and shiti_code like :shiti_code";
					}
				}else if(shiTi.getType()==0){
					hql = hql+" and type=0";
					if(shiTi.getNeirong()!=null){
						hql = hql+" and neirong like :neirong";
					}
					if(shiTi.getShiti_code()!=null){
						hql = hql+" and shiti_code like :shiti_code";
					}
				}else if(shiTi.getType()==2){
					hql = hql+" and type=2";
					if(shiTi.getNeirong()!=null){
						hql = hql+" and neirong like :neirong";
					}
					if(shiTi.getShiti_code()!=null){
						hql = hql+" and shiti_code like :shiti_code";
					}
				}
				}
				Query query = session.createQuery(hql);
				if(shiTi!=null){
					if(shiTi.getNeirong()!=null){
						query.setString("neirong", "%"+shiTi.getNeirong()+"%");
					}
					if(shiTi.getShiti_code()!=null){
						query.setString("shiti_code", "%"+shiTi.getShiti_code()+"%");
					}
				}
				List<ShiTi> list = query.setFirstResult((int)pu.getStartCursor()).
				setMaxResults(pu.getSize()).list();
				for (int i = 0; i < list.size(); i++) {  
				    Object object = list.get(i);
				    list.remove(i);
				    if (object instanceof Rightorwrong) {  
				        Rightorwrong rightorwrong = (Rightorwrong) object;
				        list.add(rightorwrong);
				    } else if (object instanceof Select) {  
				        Select select = (Select) object;
				        list.add(select);
				    }
				} 
				return list;
			}
		});
		return list;
	}


	public long getTotalRecords(ShiTi shiTi) {
		// TODO Auto-generated method stub
		String hql = "select count(id) from ShiTi where 1=1";
		List<Object> list = new ArrayList<Object>();
		if (shiTi != null) {
			if (shiTi.getShiti_code() != null) {
				hql = hql + " and shiti_code like ?";
				list.add("&" + shiTi.getShiti_code() + "%");
			}
		}
		Object[] obj = list.toArray();
		return (Long) this.hibernateTemplate.find(hql, obj).get(0);
	}

}
