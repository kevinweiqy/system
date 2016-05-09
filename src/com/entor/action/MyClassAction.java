package com.entor.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entor.model.MyClass;
import com.entor.service.MyClassService;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("myClassAction")
@Scope("prototype")
public class MyClassAction extends ActionSupport{
    
	private MyClass myClass;
	@Autowired
	private MyClassService myClassService;
	private InputStream inputStream;
	private int page;//第几页
	private int rows;//每页的记录数
	
	Map<String,Object> map=new HashMap<String,Object>();
	
	//带分页的查询antion
	public String getMyClassJsonByPage() throws UnsupportedEncodingException{
		PageUtil pu= new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);
		inputStream=myClassService.getMyClassListJsonByPage(myClass, pu);
		return SUCCESS;
	}
	
	//添加
	public String add() 
	throws UnsupportedEncodingException{
		try {
		myClassService.addMyClass(myClass);
		map.put("flag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("flag", 0);
		}//map转换成json的字符串
		JSONObject jsonObj = JSONObject.fromObject(map);
		inputStream = new ByteArrayInputStream(
				jsonObj.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	
	//删除
	public String delete() 
	throws UnsupportedEncodingException{
		try {
			myClassService.deleteMyClass(myClass);
			map.put("flag", 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				map.put("flag", 0);
			}//map转换成json的字符串
			JSONObject jsonObj = JSONObject.fromObject(map);
			inputStream = new ByteArrayInputStream(
					jsonObj.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	
	//更新
	public String update() 
	throws UnsupportedEncodingException{
		try {
			myClassService.updateMyClass(myClass);
			map.put("flag", 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				map.put("flag", 0);
			}//map转换成json的字符串
			JSONObject jsonObj = JSONObject.fromObject(map);
			inputStream = new ByteArrayInputStream(
					jsonObj.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	
	//单个查询
//	public String selectOnesClass() 
//	throws UnsupportedEncodingException{
//		try {
//		    myClassService.gatMyClass(myClass.getId());
//			map.put("flag", 1);
//			
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				map.put("flag", 0);
//			}//map转换成json的字符串
//			JSONObject jsonObj = JSONObject.fromObject(map);
//			inputStream = new ByteArrayInputStream(
//					jsonObj.toString().getBytes("utf-8"));
//		return SUCCESS;
//	}
	
	public String selectOnesClass() 
	throws UnsupportedEncodingException{
		try {
			myClass = myClassService.gatMyClass(myClass.getId());
			map.put("myClass", myClass);
			map.put("flag", 1);
			
			} catch (Exception e) {
				map.put("flag", 0);
			}//map转换成json的字符串
			JSONObject jsonObj = JSONObject.fromObject(map);
			inputStream = new ByteArrayInputStream(
					jsonObj.toString().getBytes("utf-8"));
		return SUCCESS;
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
	public MyClass getMyClass() {
		return myClass;
	}
	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
	}
	
	
}
