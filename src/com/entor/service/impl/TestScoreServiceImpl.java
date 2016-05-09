package com.entor.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Service;

import com.entor.dao.StudentDao;
import com.entor.dao.TestPaperDao;
import com.entor.dao.TestScoreDao;
import com.entor.model.ShiTi;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.service.TestScoreService;
import com.entor.utils.JsonConfigUtils;
import com.entor.utils.JsonValueProcessorImpl;
import com.entor.utils.PageUtil;
@Service("testScoreServiceImpl")
public class TestScoreServiceImpl implements TestScoreService{
	@Autowired@Qualifier("testScoreDaoImpl") 
	private TestScoreDao testScoreDao;


	/* (non-Javadoc)保存
	 * @see com.entor.service.TestScoreService#addTestScore(com.entor.model.TestScore)
	 */
	public void addTestScore(TestScore testScore) {
		
		testScoreDao.save(testScore);		
		
	}

	/* (non-Javadoc)删除
	 * @see com.entor.service.TestScoreService#deleteTestScore(com.entor.model.TestScore)
	 */
	public void deleteTestScore(TestScore testScore) {
		testScoreDao.delete(testScore);
		
	}
    /* (non-Javadoc)更新
     * @see com.entor.service.TestScoreService#updateTestScore(com.entor.model.TestScore)
     */
    public void updateTestScore(TestScore testScore) {
    	testScoreDao.update(testScore);
		
	}

	/**
	 * 根据ID查找考试成绩信息
	 * 
	 * @param id
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public InputStream getTestScoreById(int id)
			throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		//拿到对象
		TestScore testScore = testScoreDao.get(TestScore.class, id);
		System.out.println(testScore.getScore() + "=="
				+ testScore.getExaminationdate() + "=="
				+ testScore.getStu().getId());
		//转换时间格式
		JsonConfig cfg = JsonConfigUtils.getNoCycleJsonConfig();
		cfg.registerJsonValueProcessor(java.sql.Date.class,
				new JsonValueProcessorImpl());
		//转换成json的字符串
		JSONObject jsonObject = 
			JSONObject.fromObject(testScore, cfg);
		String jsonStr = 
			jsonObject.toString();
		System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));

	}

	/* (non-Javadoc)分页，以流的方式显示所有内容
	 * @see com.entor.service.TestScoreService#getTestScoreListByPage(com.entor.model.TestScore, com.entor.utils.PageUtil)
	 */
	public InputStream getTestScoreListByPage(TestScore testScore, PageUtil pu) throws UnsupportedEncodingException {
		//获取底层表里总记录数
		long totalRecords=
			testScoreDao.getTotalRecords(testScore);
		//把总记录数填充到分页对象
		pu.setTotalRecords(totalRecords);
		//获取分页对象的集合
	    List<TestScore> list=
		testScoreDao.getTestScoreListByPage(testScore, pu);
 
	JsonConfig cfg=JsonConfigUtils.getNoCycleJsonConfig();
	cfg.registerJsonValueProcessor(java.sql.Date.class, new JsonValueProcessorImpl());
	
	      Map<String,Object>map=
	    	  new HashMap<String,Object>();
	      //easy转换数据固定格式（"total":100,"rows":[{}{}]）
	      map.put("total", pu.getTotalRecords());
	      map.put("rows", list);
	      //把map集合转成JSON的字符串：包装，然后转
	      JSONObject jsonObject=
	    	  JSONObject.fromObject(map,cfg);
	      String jsonStr=jsonObject.toString();
	      System.out.println(jsonStr);
	      //字符串（STRING）以流的形式返回
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
	}

	
	//根据试卷和学生查找考试成绩
	public TestScore getTestScoreService(TestPaper tp,Student stu){
		TestScore testScore=testScoreDao.getTestScore(tp, stu);
	    return testScore;
	}

	public InputStream getStudentScore(Student stu) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		List<TestScore> ts=testScoreDao.getTestScores(stu);
		JsonConfig cfg=JsonConfigUtils.getNoCycleJsonConfig();
		cfg.registerJsonValueProcessor(java.sql.Date.class, new JsonValueProcessorImpl());
		
		      Map<String,Object>map=
		    	  new HashMap<String,Object>();
		      //easy转换数据固定格式（"total":100,"rows":[{}{}]）
		      map.put("total", ts.size());
		      map.put("rows", ts);
		      //把map集合转成JSON的字符串：包装，然后转
		      JSONObject jsonObject=
		    	  JSONObject.fromObject(map,cfg);
		      String jsonStr=jsonObject.toString();
		      System.out.println(jsonStr);
		      //字符串（STRING）以流的形式返回
			return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
	}

}
