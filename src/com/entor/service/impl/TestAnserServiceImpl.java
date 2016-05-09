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

import com.entor.dao.TestAnserDao;

import com.entor.model.Rightorwrong;
import com.entor.model.Select;
import com.entor.model.Student;
import com.entor.model.TestAnser;
import com.entor.model.TestPaper;
import com.entor.model.TestPaperShiTi;

import com.entor.service.TestAnserService;
import com.entor.utils.PageUtil;

@Service
public class TestAnserServiceImpl implements TestAnserService {
	@Autowired@Qualifier("testAnserDaoImpl")
    private TestAnserDao testAnserDao;



	/* (non-Javadoc)添加
	 * @see com.entor.service.TestAnserService#addTestAnser(com.entor.model.TestAnser)
	 */
	public void addTestAnser(TestAnser testAnser) {
		testAnserDao.save(testAnser);
		
		
	}

	/* (non-Javadoc)删除
	 * @see com.entor.service.TestAnserService#deleteTestAnser(com.entor.model.TestAnser)
	 */
	public void deleteTestAnser(TestAnser testAnser) {
		testAnserDao.delete(testAnser);
		
		
	}
	/* (non-Javadoc)更新
	 * @see com.entor.service.TestAnserService#updateTestAnser(com.entor.model.TestAnser)
	 */
	public void updateTestAnser(TestAnser testAnser) {
		testAnserDao.update(testAnser);
	}

	public InputStream getTestAnserListByPage(TestAnser testAnser, PageUtil pu)
			throws UnsupportedEncodingException {
		//获取底层表里总记录数
		long totalRecords=testAnserDao.getTotal(testAnser);
		//把总记录数填充到分页对象
		pu.setTotalRecords(totalRecords);
		//获取分页对象的集合
	     List<TestAnser> list=testAnserDao.getTestAnserListByPage(testAnser, pu);
			Map<String,Object> map = new HashMap<String, Object>();
			
			for(TestAnser ts:list){
				if(ts.getRightorwrong()!=null){
					int rid=ts.getRightorwrong().getId();
					int studentid=ts.getStudent().getId();
					int testid=ts.getTestPaper().getId();
					Rightorwrong rightorwrong = new Rightorwrong();
					rightorwrong.setId(rid);
					Student student = new Student();
					student.setId(studentid);
					TestPaper testPaper = new TestPaper();
					testPaper.setId(testid);
					ts.setRightorwrong(rightorwrong);
					ts.setStudent(student);
					ts.setTestPaper(testPaper);
				}
				if(ts.getSelect()!=null){
					int sid=ts.getSelect().getId();
					int studentid=ts.getStudent().getId();
					int testid=ts.getTestPaper().getId();
					Select select = new Select();
					select.setId(sid);
					Student student = new Student();
					student.setId(studentid);
					TestPaper testPaper = new TestPaper();
					testPaper.setId(testid);
					ts.setSelect(select);
					ts.setStudent(student);
					ts.setTestPaper(testPaper);
				}
			}
			map.put("total", pu.getTotalRecords());
			map.put("rows", list);
			JSONObject jsonObject = JSONObject.fromObject(map);
			String jsonStr = jsonObject.toString();
			System.out.println(jsonStr);
			return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
	}

	public TestAnser getTestAnser(TestAnser testAnser) {
		// TODO Auto-generated method stub
		return testAnserDao.get(TestAnser.class,testAnser.getId());
	}



}
