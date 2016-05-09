package com.entor.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entor.dao.MyClassDao;
import com.entor.dao.ShiTiDao;
import com.entor.dao.TestPaperDao;
import com.entor.dao.TestPaperShiTiDao;
import com.entor.dao.TestScoreDao;
import com.entor.model.MyClass;
import com.entor.model.ShiTi;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestPaperShiTi;
import com.entor.model.TestScore;
import com.entor.service.TestPaperService;
import com.entor.utils.JsonConfigUtils;
import com.entor.utils.JsonValueProcessorImpl;
import com.entor.utils.PageUtil;
@Service("testPaperServiceImpl")
public class TestPaperServiceImpl implements TestPaperService{
	@Autowired
	private TestPaperDao testPaperDao;
    @Autowired @Qualifier("shiTiDaoImpl")
	private ShiTiDao std;
    @Autowired @Qualifier("testPaperShiTiDaoImpl")
    private TestPaperShiTiDao testPaperShiTiDao;
    @Autowired @Qualifier("testScoreDaoImpl")
    private TestScoreDao testScoreDao;
    
    
    
	//增加试卷信息
	public void addTestPaperService(TestPaper tp) {
		testPaperDao.save(tp);
		
	}

	//删除试卷信息
	public void deleteTestPaperService(TestPaper tp) {
		//需要删除中间表，成绩表，如果试卷状态是已经考完试，就不能删除
		
		TestPaper tp1=testPaperDao.get(TestPaper.class,tp.getId());
		testPaperDao.delete(tp1);		
		
	}

	//取试卷集合
	public InputStream getTestPaperListByPageService(TestPaper tp, PageUtil pu) throws UnsupportedEncodingException{	    
	  //把集合转成json字符串 异步要以这样的数据格式传回去
		//转成json数组集合就用JSONArray
		long totalRecords =testPaperDao.getTotalRecords(tp);
		pu.setTotalRecords(totalRecords);
		Map<String,Object> map=new HashMap<String, Object>();
		//取到分页的集合
		List<TestPaper> list=testPaperDao.getTestPaperlistByPage(tp,pu);
		
		JsonConfig cfg=JsonConfigUtils.getNoCycleJsonConfig();
		cfg.registerJsonValueProcessor(java.sql.Date.class, new JsonValueProcessorImpl());
		
		map.put("total",pu.getTotalRecords());
		map.put("rows", list);
		JSONObject jsonObject=JSONObject.fromObject(map,cfg);//转成json数组
		String jsonStr= jsonObject.toString();
		System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));//new inputstream子类
	}
	
	
	//取单选题集合
	public InputStream getShiTiService(ShiTi st, PageUtil pu) throws UnsupportedEncodingException{	    
	  //把集合转成json字符串 异步要以这样的数据格式传回去
		//转成json数组集合就用JSONArray
		long totalRecords =std.getTotalRecords(st);
		pu.setTotalRecords(totalRecords);
		Map<String,Object> map=new HashMap<String, Object>();
		//取到分页的集合
		List<ShiTi> list=std.getSelectlistByPage(st, pu);
		
		JsonConfig cfg=JsonConfigUtils.getNoCycleJsonConfig();
		cfg.registerJsonValueProcessor(java.sql.Date.class, new JsonValueProcessorImpl());
		
		map.put("total",pu.getTotalRecords());
		map.put("rows", list);
		JSONObject jsonObject=JSONObject.fromObject(map,cfg);//转成json数组
		String jsonStr= jsonObject.toString();
		System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));//new inputstream子类
	}

	//获取一张试卷的流
	public InputStream getTestPaperService(int id) throws UnsupportedEncodingException {
		TestPaper tp=testPaperDao.get(TestPaper.class,id);
	  
		//转换时间格式
		JsonConfig cfg = JsonConfigUtils.getNoCycleJsonConfig();
		cfg.registerJsonValueProcessor(java.sql.Date.class,
				new JsonValueProcessorImpl());
		  
	    JSONObject jsonObject=JSONObject.fromObject(tp,cfg);//转成json数组
	  
		String jsonStr= jsonObject.toString();
		System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));//new inputstream子类
	}
	
	
	//获取一张试卷对象
	public TestPaper getPaperService(TestPaper tp){
		TestPaper tp1=testPaperDao.get(TestPaper.class,tp.getId());				
		return tp1;
	}

	
	//更新试卷信息
	public void updateTestPaperService(TestPaper tp) {
		
		testPaperDao.update(tp);
	} 
	
	
	//添加随机试题
	public void addDefaultPaperService(TestPaper tp){
		//添加单选择题(其实是往试卷试题中间表添加记录)
		  int danNum=tp.getSelect_number();//单选题数
		  ShiTi st1=new ShiTi();
		  st1.setType(0);
		  PageUtil pu=new PageUtil();
		  pu.setPageNo(1);
		  pu.setSize(500);
	      List<ShiTi> list1=std.getSelectlistByPage(st1,pu);
	      Random rd1=new Random();
	      for(int i=1;i<=danNum;i++){
	    	  if(list1.size()>=(danNum-i)){
	    		  int a=rd1.nextInt(list1.size());
		    	  ShiTi ti1=list1.get(a);//获取随机试题
		    	  TestPaperShiTi ps1=new TestPaperShiTi();
				      ps1.setShiTi(ti1);
				      ps1.setTestPaper(tp);
				      //保存ps1就相当于单选择题了
				      testPaperShiTiDao.save(ps1);
				      list1.remove(a);//去掉控制重复问题   
	    	  }    	  
	      }	      
		  
		//添加多选择题
		  int duoNum=tp.getSelects_number();//多选题数
		  ShiTi st2=new ShiTi();
		  st2.setType(2);
		  List<ShiTi> list2=std.getSelectlistByPage(st2,pu);
		  Random rd2=new Random();
	      for(int i=1;i<=danNum;i++){
	    	  if(list2.size()>=(duoNum-i)){
	    		  int a=rd2.nextInt(list2.size());
		    	  ShiTi ti2=list2.get(a);//获取随机试题
		    	  TestPaperShiTi ps2=new TestPaperShiTi();
				  ps2.setShiTi(ti2);
				  ps2.setTestPaper(tp);
				  //保存ps1就相当于添多选择题了
				  testPaperShiTiDao.save(ps2); 
				  list2.remove(a);//去掉控制重复问题   
	    	  }    	
	      }	
	      
		  //添加判断题
		  int panNum=tp.getRightorwrong_number();//判断题数
		  ShiTi st3=new ShiTi();
		  st3.setType(1);
		  List<ShiTi> list3=std.getSelectlistByPage(st3,pu);
		  Random rd3=new Random();
	      for(int i=1;i<=danNum;i++){
	    	  if(list3.size()>=(panNum-i)){
	    		  int a=rd3.nextInt(list3.size());
		    	  ShiTi ti3=list3.get(a);//获取随机试题
		    	  TestPaperShiTi ps3=new TestPaperShiTi();
				  ps3.setShiTi(ti3);
				  ps3.setTestPaper(tp);
				  //保存ps3就相当于添加判断题了
				  testPaperShiTiDao.save(ps3); 
	              list3.remove(a);//去掉控制重复问题   
	    	  }    	  	  
	      }
	}

	
	/**
	 * 手动添加的试题保存
	 */
	public void savePaperShiTiService(String s){
		String[] str=s.split(",");
		String paper_id=str[1];//试卷编码
		int paperid=Integer.parseInt(paper_id);//转成int
		TestPaper tp=testPaperDao.get(TestPaper.class,paperid);	//获取试卷对象
		//遍历数组,循环为试卷添加试题，也就是往试题试卷中间表添加数据
		for(int i=2;i<str.length;i++){
			String s1=str[i];
			int s2=Integer.parseInt(s1);
			if(paperid!=s2){
				ShiTi shiti=std.get(ShiTi.class,s2);
				TestPaperShiTi ps=new TestPaperShiTi();
			    ps.setShiTi(shiti);//设置试题
			    ps.setTestPaper(tp);//设置试卷
			    //保存ps3就相当于添加题目了
			    testPaperShiTiDao.save(ps);
			}
		}
	}
	
	
	/**
	 * 通过班级编号找出班级对应的学生集合
	 */
	public void addTestStudents(TestPaper tp,MyClass myClass) {
		TestPaper testPaper=(TestPaper)testPaperDao.get(TestPaper.class, tp.getId());
		List<Student> list=testPaperDao.getStudentList(myClass.getClassNumber());
		for (Student student : list) {
			TestScore testScore = new TestScore();
			testScore.setTp(testPaper);
			testScore.setStu(student);
			testScore.setScore(-1);
			testScore.setBuScore(0);
			testScore.setIsPass(0);
			testScore.setPass(0);
			testScore.setExaminationdate(testPaper.getBeginTime());
			testScoreDao.save(testScore);
			
		}
	}



}
