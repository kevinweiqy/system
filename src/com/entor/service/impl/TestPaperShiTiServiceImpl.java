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

import com.entor.dao.TestPaperShiTiDao;
import com.entor.model.ShiTi;
import com.entor.model.TestPaperShiTi;
import com.entor.service.TestPaperShiTiService;
import com.entor.utils.PageUtil;
@Service
public class TestPaperShiTiServiceImpl implements TestPaperShiTiService{

	@Autowired@Qualifier("testPaperShiTiDaoImpl")
	private TestPaperShiTiDao testPaperShiTiDao;
	public void addTestPaperShiTi(TestPaperShiTi testPaperShiTi) {
		// TODO Auto-generated method stub
		testPaperShiTiDao.save(testPaperShiTi);
	}

	public void deleteTestPaperShiTi(TestPaperShiTi testPaperShiTi) {
		// TODO Auto-generated method stub
		testPaperShiTiDao.delete(testPaperShiTi);
	}

	public TestPaperShiTi getTestPaperShiTi(int id) {
		// TODO Auto-generated method stub
		TestPaperShiTi testPaperShiTi =
			testPaperShiTiDao.get(TestPaperShiTi.class, id);
		return testPaperShiTi;
	}

	public InputStream getTestPaperShiTiListByPage(
			TestPaperShiTi testPaperShiTi, PageUtil pu)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		//获得记录总数
		long totalRecords =testPaperShiTiDao.getTotalRecords(testPaperShiTi);
		//填充总的记录数
		pu.setTotalRecords(totalRecords);
		//获得分页对象
		List<TestPaperShiTi> list = testPaperShiTiDao.getTestPeperShiTiListByPage(testPaperShiTi, pu);
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("total", pu.getTotalRecords());
		map.put("row", list);
		JSONObject jsonObject = JSONObject.fromObject(map);
		String jsonStr = jsonObject.toString();
		System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
	}

	public void updateTestPaperShiTi(TestPaperShiTi testPaperShiTi) {
		// TODO Auto-generated method stub
		testPaperShiTiDao.update(testPaperShiTi);
	}

}
