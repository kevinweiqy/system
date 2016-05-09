package com.entor.action.YhJsAtion;

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
import com.entor.model.JS_XX;
import com.entor.model.YH_JS;
import com.entor.service.AdminService;
import com.entor.service.JsxxService;
import com.entor.service.YhJsService;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;
@Controller("yhJsAtion") //@Scope("prototype")
public class YhJsAtion extends ActionSupport {	
	private Admin admin;
	private JS_XX jx;
	private int aid;
	private String formData;
	public String getFormData() {
		return formData;
	}
	public void setFormData(String formData) {
		this.formData = formData;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public JS_XX getJx() {
		return jx;
	}
	public void setJx(JS_XX jx) {
		this.jx = jx;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getJid() {
		return jid;
	}
	public void setJid(int jid) {
		this.jid = jid;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	private int jid;
	@Autowired @Qualifier("adminServiceImpl")
	private AdminService as;
	@Autowired @Qualifier("YhJsServiceImpl")
	private YhJsService ys;
	@Autowired @Qualifier("JsxxServiceImpl")
	private JsxxService js;
	private InputStream inputStream;
	//新增
	public String addYhJsAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			Admin admin1 = new Admin();
			admin1=as.getAdmin(aid);
			 JS_XX jx1 = new JS_XX();
			 jx1=js.getJS_XX(jid);
			YH_JS yhjs = new YH_JS();
			yhjs.setAdmin(admin1);
			yhjs.setJs_xx(jx1);
			ys.YhJsAdd(yhjs);
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
	//删除用户拥有的角色，传入角色id；用户id
	public String deleteYhJsAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			String form[] = formData.split("&");
			String form1[] = form[0].split("=");
			String ids = form1[1];
			Admin admin1 = new Admin();
			admin1=as.getAdmin(Integer.parseInt(ids));
			 JS_XX jx1 = new JS_XX();
			 jx1=js.getJS_XX(jid);
			YH_JS yhjs = new YH_JS();
			yhjs.setAdmin(admin1);
			yhjs.setJs_xx(jx1);
			ys.YhJsdelete(yhjs);
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
	//根据用户ID查所拥有的角色
	public String selectYhJsAction() throws UnsupportedEncodingException{
		String form[] = formData.split("&");
		String form1[] = form[0].split("=");
		String ids = form1[1];
		inputStream=ys.getJSList(Integer.parseInt(ids));
		return SUCCESS;
	}
}
