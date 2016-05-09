package com.entor.action.admin;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entor.model.Admin;
import com.entor.service.AdminService;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;
@Controller("adminAction") //@Scope("prototype")
public class AdminAction extends ActionSupport {
	
	private Admin admin;
	@Autowired @Qualifier("adminServiceImpl")
	private AdminService as;
	
	private InputStream inputStream;
	private int page;//第几页
	private int rows;//每页的记录数
	private int pageSize;//转过来
//	private int id;
	
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public AdminService getAs() {
		return as;
	}
	public void setAs(AdminService as) {
		this.as = as;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	//新增
	public String addAdminAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			as.addAdmin(admin);
		  map.put("flag", 1);
		}catch(Exception e){
			e.printStackTrace();
			map.put("flag",0);
		}	
		//map转化成json字符串
		JSONObject jsonObject=JSONObject.fromObject(map);
		inputStream=new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	//修改
	public String updateAdminAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			as.updateAdmin(admin);
		  map.put("flag", 1);
		}catch(Exception e){
			e.printStackTrace();
			map.put("flag",0);
		}	
		//map转化成json字符串
		JSONObject jsonObject=JSONObject.fromObject(map);
		inputStream=new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	//删除
	public String deleteAdminAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{			
			as.deleteAdmin(as.getAdmin(admin.getId()));
		  map.put("flag", 1);
		}catch(Exception e){
			e.printStackTrace();
			map.put("flag",0);
		}	
		//map转化成json字符串
		JSONObject jsonObject=JSONObject.fromObject(map);
		inputStream=new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	//查看单个
	public String getAdminAction() throws UnsupportedEncodingException{		
		Admin admin1 = null;
		try{
			admin1 = as.getAdmin(admin.getId());		
		}catch(Exception e){
			e.printStackTrace();
		}			
		JSONObject jsonObject=JSONObject.fromObject(admin1);
		inputStream=new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	//分页查询action
	public String getAdminByPage() throws UnsupportedEncodingException{		
		PageUtil pu=new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);		
		inputStream=as.getAdminListByPage(admin, pu);
		return SUCCESS;		
	}
	//查看所有
	public String getAdminAllAction() throws UnsupportedEncodingException{
		inputStream=as.getAdminList();
		return SUCCESS;
	}
}
