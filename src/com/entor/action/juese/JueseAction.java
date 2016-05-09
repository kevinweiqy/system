package com.entor.action.juese;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.entor.model.Admin;
import com.entor.model.JS_XX;
import com.entor.service.JsxxService;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("jueseAction")
public class JueseAction  extends ActionSupport {
	private JS_XX jx;
	@Autowired @Qualifier("JsxxServiceImpl")
	private JsxxService js;	
	private InputStream inputStream;
	private int page;//第几页
	private int rows;//每页的记录数
	private int pageSize;//转过来
	//新增
	public String addJuSeAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			js.addJS_XX(jx);
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
	public String getJuSeAction() throws UnsupportedEncodingException{		
		JS_XX jx1 = null;
		try{
			jx1 = js.getJS_XX(jx.getId());		
		}catch(Exception e){
			e.printStackTrace();
		}			
		JSONObject jsonObject=JSONObject.fromObject(jx1);
		inputStream=new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	//修改
	public String updateJuSeAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			js.updateJS_XX(jx);
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
	public String deleteJuSeAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{						
			js.deleteJS_XX(js.getJS_XX(jx.getId()));
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
	//分页查询action
	public String getJuSeByPage() throws UnsupportedEncodingException{		
		PageUtil pu=new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);		
		inputStream=js.getJS_XXList(jx, pu);
		return SUCCESS;		
	}
	public String getAllJx() throws UnsupportedEncodingException{				
		inputStream=js.getJS_XXList();
		return SUCCESS;		
	}
	public JS_XX getJx() {
		return jx;
	}
	public void setJx(JS_XX jx) {
		this.jx = jx;
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
}
