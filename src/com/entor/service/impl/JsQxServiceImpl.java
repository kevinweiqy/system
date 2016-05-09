package com.entor.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entor.dao.JS_QX_Dao;
import com.entor.dao.YH_JS_Dao;
import com.entor.model.JS_QX;
import com.entor.model.JS_XX;
import com.entor.model.QX_INFO;
import com.entor.service.JsQxService;
@Service
public class JsQxServiceImpl implements JsQxService{
	
	@Autowired @Qualifier("jS_QX_Dao_impl")
	private JS_QX_Dao yqd;

	public void addJsQx(JS_QX jq) throws Exception {
		// TODO Auto-generated method stub
		yqd.save(jq);
	}

	public void deleteJsQx(JS_QX jq) {
		// TODO Auto-generated method stub
		yqd.delete(jq);
	}

	public InputStream getAllJsQxOList() throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		List<JS_QX> list = yqd.getAllJS_QXList();
		// TODO Auto-generated method stub
		JSONArray ja = JSONArray.fromObject(list);
		String jst = ja.toString();
		return new ByteArrayInputStream(jst.getBytes("utf-8"));
	}

	public InputStream getJsQxList(int id) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		List<QX_INFO> list = yqd.getQxList(id);
		// TODO Auto-generated method stub
		JSONArray ja = JSONArray.fromObject(list);
		String jst = ja.toString();
		return new ByteArrayInputStream(jst.getBytes("utf-8"));
	}
}
