package com.entor.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.entor.dao.JS_XX_Dao;
import com.entor.model.Admin;
import com.entor.model.JS_XX;
import com.entor.service.JsxxService;
import com.entor.utils.PageUtil;
@Service("JsxxServiceImpl")
public class JsxxServiceImpl implements JsxxService{
	@Autowired @Qualifier("jS_XX_Dao_impl")
	private JS_XX_Dao jsd;
	public void addJS_XX(JS_XX jsxx) {
		// TODO Auto-generated method stub
		jsd.save(jsxx);
	}

	public void deleteJS_XX(JS_XX jsxx) {
		// TODO Auto-generated method stub
		jsd.delete(jsxx);
	}

	public JS_XX getJS_XX(int id) {
		// TODO Auto-generated method stub
		return jsd.get(JS_XX.class, id);
	}

	public InputStream getJS_XXList(JS_XX jsxx,PageUtil pu)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		long totalRecords =jsd.getTotalRecords(jsxx);
		pu.setTotalRecords(totalRecords);
		Map<String,Object> map=new HashMap<String, Object>();
		List<JS_XX> list = jsd.getAllJS_XXList(jsxx,pu);
		map.put("total",pu.getTotalRecords());
		map.put("rows", list);
		JSONObject jsonObject=JSONObject.fromObject(map);//转成json数组
		String jsonStr= jsonObject.toString();
        System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
	}

	public void updateJS_XX(JS_XX jsxx) {
		// TODO Auto-generated method stub
		jsd.update(jsxx);
	}

	public List<JS_XX> getList(JS_XX jsxx) {
		// TODO Auto-generated method stub
		List<JS_XX> list = jsd.getAllJS_XXList();
		return list;
	}
	public InputStream getJS_XXList() throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		List<JS_XX> list = jsd.getAllJS_XXList();
		JSONArray ja = JSONArray.fromObject(list);
		String jstr = ja.toString();		
		return new ByteArrayInputStream(jstr.getBytes("utf-8"));
	}
}
