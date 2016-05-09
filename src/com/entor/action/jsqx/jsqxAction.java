package com.entor.action.jsqx;

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
import com.entor.model.JS_QX;
import com.entor.model.JS_XX;
import com.entor.model.QX_INFO;
import com.entor.model.YH_JS;
import com.entor.service.JsQxService;
import com.entor.service.JsxxService;
import com.entor.service.QX_INFOService;
import com.opensymphony.xwork2.ActionSupport;
@Controller("jsqxAction") 
public class jsqxAction extends ActionSupport{
	private JS_XX jx;
	private QX_INFO qi;
	private int qid;
	private String formData;
	private int jid;
	@Autowired @Qualifier("jsQxServiceImpl")
	private JsQxService jqs;
	@Autowired @Qualifier("JsxxServiceImpl")
	private JsxxService js;
	@Autowired @Qualifier("QX_INFOServiceImpl")
	private QX_INFOService qs;
	private InputStream inputStream;
	//新增
	public String addJsQxAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			 JS_XX jx1 = new JS_XX();
			 jx1=js.getJS_XX(jid);
			 QX_INFO qi1= new QX_INFO();
			 qi1=qs.getQxINFO(qid);
			 JS_QX jq = new JS_QX();
			 jq.setJs_xx(jx1);
			 jq.setQx_info(qi1);
			 jqs.addJsQx(jq);
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
	//根据角色ID查所拥有的权限
	public String selectJsQxAction() throws UnsupportedEncodingException{
		String form[] = formData.split("&");
		String form1[] = form[0].split("=");
		String ids = form1[1];
		inputStream=jqs.getJsQxList(Integer.parseInt(ids));
		return SUCCESS;
	}
	//删除角色的权限
	public String deleteJsQxAction() throws UnsupportedEncodingException{
		Map<String,Object> map=new HashMap<String, Object>();
		try{
			String form[] = formData.split("&");
			String form1[] = form[0].split("=");
			String ids = form1[1];
			JS_XX jx1 = new JS_XX();
			jx1=js.getJS_XX(Integer.parseInt(ids));
			 QX_INFO qi1= new QX_INFO();
			 qi1=qs.getQxINFO(qid);
			 JS_QX jq = new JS_QX();
			 jq.setJs_xx(jx1);
			 jq.setQx_info(qi1);
			 jqs.deleteJsQx(jq);
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
	public JS_XX getJx() {
		return jx;
	}
	public void setJx(JS_XX jx) {
		this.jx = jx;
	}
	public QX_INFO getQi() {
		return qi;
	}
	public void setQi(QX_INFO qi) {
		this.qi = qi;
	}
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getFormData() {
		return formData;
	}
	public void setFormData(String formData) {
		this.formData = formData;
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
}
