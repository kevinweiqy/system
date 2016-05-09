package com.entor.action.qxAction;

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

import com.entor.model.QX_INFO;
import com.entor.service.QX_INFOService;
import com.entor.service.impl.QX_INFOServiceImpl;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
@Controller("qxListAction")@Scope("prototype")
public class QxListAction extends ActionSupport{
	private QX_INFO qx;
	@Autowired @Qualifier("QX_INFOServiceImpl")
	private QX_INFOService qi;
	private InputStream inputStream;
	private int page;//第几页           
	private int rows;//每页的记录数
	private int pageSize;//转过来
	private int qxid;//父级权限ID
	public int getQxid() {
		return qxid;
	}
	public void setQxid(int qxid) {
		this.qxid = qxid;
	}
	//新增
	public String addQxAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			QX_INFO qx1=new QX_INFO();
			if(qxid!=0){
				qx1=qi.getQxINFO(qxid);
				qx.setFather(qx1);
				qi.addQxINFO(qx);
			}else{
				
				qi.addQxINFO(qx);
			}			
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
	public String getQxAction() throws UnsupportedEncodingException{		
		QX_INFO qx1 = null;
		try{
			qx1 = qi.getQxINFO(qx.getId());		
		}catch(Exception e){
			e.printStackTrace();
		}			
		JSONObject jsonObject=JSONObject.fromObject(qx1);
		inputStream=new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	//修改
	public String updateQxAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			qi.updateQxINFO(qx);
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
	public String deleteQxAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{									
			qi.deleteQxINFO(qi.getQxINFO(qx.getId()));
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
	public String getQxByPage() throws UnsupportedEncodingException{		
		PageUtil pu=new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);		
		inputStream=qi.getQX_INFOJsonByPage(qx, pu);
		return SUCCESS;		
	}
	//查看所有
	public String getQxAllAction() throws UnsupportedEncodingException{
		inputStream=qi.getAllQX_INFOList();
		return SUCCESS;
	}
	public QX_INFO getQx() {
		return qx;
	}
	public void setQx(QX_INFO qx) {
		this.qx = qx;
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
