package com.entor.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entor.dao.ShiTiDao;
import com.entor.model.Rightorwrong;
import com.entor.model.Select;
import com.entor.model.ShiTi;
import com.entor.service.ShiTiService;
import com.entor.utils.PageUtil;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
@Service
public class ShiTiServiceImpl implements ShiTiService{

	@Autowired@Qualifier("shiTiDaoImpl")
	private ShiTiDao shiTiDao;
	public void addShiTi(ShiTi shiTi) {
		// TODO Auto-generated method stub
		shiTiDao.save(shiTi);
	}

	public void deleteShiTi(ShiTi shiTi) {
		// TODO Auto-generated method stub
		shiTiDao.delete(shiTi);
	}

	public InputStream getShiTiListByPage(ShiTi shiTi,PageUtil pu) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		//获得记录总数
		long totalRecords = shiTiDao.getTotalRecords(shiTi);
		//填充总的记录数
		pu.setTotalRecords(totalRecords);
		//获得分页对象
		List<ShiTi> list = shiTiDao.getSelectlistByPage(shiTi, pu);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", pu.getTotalRecords());
		map.put("rows", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		String jsonStr = jsonObject.toString();
		System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
	}

	public void updateShiTi(ShiTi shiTi) {
		// TODO Auto-generated method stub
		shiTiDao.update(shiTi);
	}

	public Rightorwrong getRightorwrong(int id) {
		// TODO Auto-generated method stub
		return (Rightorwrong)shiTiDao.get(Rightorwrong.class, id);
	}

	public Select getSelect(int id) {
		// TODO Auto-generated method stub
		return (Select)shiTiDao.get(Select.class, id);
	}

}
