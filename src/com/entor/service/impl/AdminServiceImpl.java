package com.entor.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entor.dao.AdminDao;
import com.entor.dao.QxInfoDao;
import com.entor.model.Admin;
import com.entor.model.QX_INFO;
import com.entor.model.QxInfoTree;
import com.entor.service.AdminService;
import com.entor.utils.PageUtil;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired @Qualifier("adminDaoImpl")
	private AdminDao adminDao;
	@Autowired @Qualifier("qxInfoDaoImpl")
	private QxInfoDao qd;
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.save(admin);
	}
//22
	public void deleteAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.delete(admin);
	}

	public Admin getAdmin(int id) {
		// TODO Auto-generated method stub
		return adminDao.get(Admin.class, id);
	}

	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		adminDao.update(admin);
	}

	public InputStream getAdminListByPage(Admin admin, PageUtil pu)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		long totalRecords =adminDao.getTotalRecords(admin);
		pu.setTotalRecords(totalRecords);
		Map<String,Object> map=new HashMap<String, Object>();
		List<Admin> list = adminDao.getAdminlistByPage(admin, pu);
		map.put("total",pu.getTotalRecords());
		map.put("rows", list);
		JSONObject jsonObject=JSONObject.fromObject(map);//转成json
		String jsonStr= jsonObject.toString();
        System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
	}
	public List<Admin> getAdminByName(Admin admin) {
		// TODO Auto-generated method stub
		List<Admin> list= adminDao.getAdminList(admin);
		return list;
	}
	public boolean getBoolean(String loginName, String pwd) {
		// TODO Auto-generated method stub
		boolean fag = adminDao.getAdmin(loginName, pwd);
		return fag;
	}
	
	public InputStream getQxList(String loginName,int id ) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setAdmin_number(loginName);		
		List<QX_INFO> list = qd.getQX_INFOList(getAdminByName(admin).get(0).getId());
		//先分级
		List li1= new ArrayList();//一级菜单集合
		List li2= new ArrayList();//二级菜单集合
		
		List listAll = new ArrayList();
//		StringBuilder sb = new StringBuilder();
//		String qxAll = null;
		for (QX_INFO qxINFO : list) {
			if(qxINFO.getMenu()==0){
				li1.add(qxINFO);
			}
			if(qxINFO.getMenu()==1){
				li2.add(qxINFO);
			}			
		}
		if(id==0){
		Iterator<QX_INFO>iterator = li1.iterator();		
		while(iterator.hasNext()){			
				QxInfoTree qt = new QxInfoTree();
				QX_INFO qi	= iterator.next();				
				qt.setId(qi.getId());
				qt.setText(qi.getQx_name());
				qt.setState("closed");
				List<QxInfoTree> ls = new ArrayList<QxInfoTree>();
				qt.setChildren(ls);
				listAll.add(qt);
			}	
		}
		else{
			Iterator<QX_INFO>iterator2 = li2.iterator();		
			while(iterator2.hasNext()){
					QxInfoTree qt2 = new QxInfoTree();
					QX_INFO qi2	= iterator2.next();	
					if(id==qi2.getFather().getId()){
						Map<String ,Object> urlMap = new HashMap<String, Object>();
						urlMap.put("url", qi2.getQx_url());
						qt2.setId(qi2.getId());
						qt2.setText(qi2.getQx_name());
						qt2.setUrl(qi2.getQx_url());
						qt2.setAttributes(urlMap);
						listAll.add(qt2);
					}
			}
		}	
		JSONArray jo2 = JSONArray.fromObject(listAll);
		String jsonStr= jo2.toString();
        //System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));

	}
	public InputStream getAdminList() throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		List<Admin> list = adminDao.getAdminList();
		JSONArray ja = JSONArray.fromObject(list);
		String jstr = ja.toString();		
		return new ByteArrayInputStream(jstr.getBytes("utf-8"));
	}
	public Admin getAdminName(String loginName){
		return adminDao.getAdminName(loginName);
	}
}
