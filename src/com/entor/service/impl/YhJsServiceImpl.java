package com.entor.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entor.dao.AdminDao;
import com.entor.dao.YH_JS_Dao;
import com.entor.model.Admin;
import com.entor.model.JS_XX;
import com.entor.model.Student;
import com.entor.model.YH_JS;
import com.entor.service.YhJsService;
@Service("YhJsServiceImpl")
public class YhJsServiceImpl implements YhJsService{
	
	@Autowired @Qualifier("yH_JS_Dao_impl")
	private YH_JS_Dao yhd;
	public void YhJsAdd(YH_JS yhjs) throws Exception {
		// TODO Auto-generated method stub
		yhd.save(yhjs);
	}

	public void YhJsdelete(YH_JS yhjs) {
		// TODO Auto-generated method stub
		yhd.delete(yhjs);
	}

	public void YhJsupdate(YH_JS yhjs) {
		// TODO Auto-generated method stub
		yhd.update(yhjs);
	}

	public InputStream getYH_JSList()
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		List<YH_JS> list = yhd.getAllYH_JSList();
		JSONObject jsonObject=JSONObject.fromObject(list);//转成json数组
		String jsonStr= jsonObject.toString();
        System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
	}

	public InputStream getJSList(int id) throws UnsupportedEncodingException {
		List<JS_XX> list = yhd.getJS_XXList(id);
		// TODO Auto-generated method stub
		JSONArray ja = JSONArray.fromObject(list);
		String jst = ja.toString();
		return new ByteArrayInputStream(jst.getBytes("utf-8"));
	}
	
}
