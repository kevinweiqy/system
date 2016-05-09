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

import com.entor.dao.QxInfoDao;

import com.entor.model.QX_INFO;

import com.entor.service.QX_INFOService;
import com.entor.utils.PageUtil;

@Service("QX_INFOServiceImpl")
public class QX_INFOServiceImpl implements QX_INFOService {
	@Autowired @Qualifier("qxInfoDaoImpl")
	private QxInfoDao qxInfoDao;

	/**
	 *增加
	 */

	public void addQxINFO(QX_INFO qxINFO) throws Exception {
		// TODO Auto-generated method stub
		qxInfoDao.save(qxINFO);

	}
	/**
	 * 删除
	 */
	public void deleteQxINFO(QX_INFO qxINFO) {
		// TODO Auto-generated method stub
		qxInfoDao.delete(qxINFO);
		// String str = null;
		// str.equals("abc");
	}

	/**
	 * 更新
	 */
	public void updateQxINFO(QX_INFO qxINFO) {
		// TODO Auto-generated method stub
		qxInfoDao.update(qxINFO);

	}

	/**
	 * 分页
	 */
	public InputStream getQX_INFOJsonByPage(QX_INFO qxINFO, PageUtil pu)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub

		long totalRecords =qxInfoDao.getTotalRecords(qxINFO);
		pu.setTotalRecords(totalRecords);
		List<QX_INFO> list = qxInfoDao.getQX_INFOlistByPage(qxINFO, pu);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pu.getTotalRecords());
		map.put("rows", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		String jsonStr = jsonObject.toString();
		System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
	}

	/**
	 * 查找
	 */
	public QX_INFO getQxINFO(int id) {
		// TODO Auto-generated method stub
		return qxInfoDao.get(QX_INFO.class, id);
	}

	/**
	 * 查询所有
	 * @throws UnsupportedEncodingException 
	 */
	public InputStream getAllQX_INFOList() throws UnsupportedEncodingException {
		List<QX_INFO> list = qxInfoDao.getAllQX_INFOList();
		JSONArray ja = JSONArray.fromObject(list);
		String jstr = ja.toString();		
		return new ByteArrayInputStream(jstr.getBytes("utf-8"));
	}

}
