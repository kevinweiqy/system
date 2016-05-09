package com.entor.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entor.dao.AdminDao;
import com.entor.dao.MyClassDao;
import com.entor.dao.TestPaperDao;

import com.entor.model.Admin;
import com.entor.model.MyClass;
import com.entor.model.ShiTi;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.service.TestPaperService;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("testPaperAction")
@Scope("prototype")
public class TestPaperAction extends ActionSupport{
    
	private TestPaper tp;
    private MyClass myClass;
    private String classNum;
    
    @Autowired @Qualifier("testPaperServiceImpl")
    private TestPaperService tps;
	private InputStream inputStream;
	private int page;//第几页
	private int rows;// 每页的记录数
	private int type;//试题类型
	private String qpaper;//试卷试题
	private String setupDateTest;
	private String startTime;
	private String endTime;
	
	private Admin teacher;
	
	@Autowired
	private AdminDao adminDao;
	private int teacherid;
	
	@Autowired @Qualifier("testPaperDaoImpl")
	TestPaperDao testPaperDao;
		

	//分页查询action
	public String getTestPaperByPage() throws UnsupportedEncodingException{
		PageUtil pu=new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);
		inputStream=tps.getTestPaperListByPageService(tp, pu);
		return SUCCESS;		
	
	}
	
	//增加试卷action
	public String addPaper() throws UnsupportedEncodingException, ParseException{
		//调用service保存，这里是模拟
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("flag", 1);
		map.put("msg","保存成功");
		//时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		Date date1 = sdf.parse(setupDateTest);
		tp.setSetupDate(date1);
		Date date2 = sdf.parse(startTime);
		tp.setBeginTime(date2);
		Date date3 = sdf.parse(endTime);
		tp.setEndTime(date3);
		Admin teacher=adminDao.get(Admin.class, teacherid);
		
		tp.setTeacher(teacher);
	    tps.addTestPaperService(tp);
	    
		JSONObject jsonObject=JSONObject.fromObject(map);
		String jsonStr= jsonObject.toString();
		inputStream=new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
		return SUCCESS;	
	}
	


	//查询一张试卷的action
	public String getPaper() throws UnsupportedEncodingException{
		inputStream=tps.getTestPaperService(tp.getId());
		return SUCCESS;		
	}
	
	//修改试卷action
	public String updatePaper() throws UnsupportedEncodingException, ParseException{
		Admin teacher=adminDao.get(Admin.class, teacherid);
		tp.setTeacher(teacher);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		Date date1 = sdf.parse(setupDateTest);
		tp.setSetupDate(date1);
		Date date2 = sdf.parse(startTime);
		tp.setBeginTime(date2);
		Date date3 = sdf.parse(endTime);
		tp.setEndTime(date3);
	    tps.updateTestPaperService(tp);	
		//调用service保存，这里是模拟
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("flag", 1);
		map.put("msg","修改成功");
		JSONObject jsonObject=JSONObject.fromObject(map);
		String jsonStr= jsonObject.toString();
		inputStream=new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
		return SUCCESS;	
	}
	
	
	public String delete() throws UnsupportedEncodingException{
		//调用service删除   car.no可以取出来进行删除操作
		tps.deleteTestPaperService(tp);		
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("flag", 1);
		map.put("msg","删除成功");
		JSONObject jsonObject=JSONObject.fromObject(map);
		String jsonStr= jsonObject.toString();
		inputStream=new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
		return SUCCESS;
	}
	
	//随机添加试题（有待验证）
	public String addDefaultPaper() throws UnsupportedEncodingException{
		
		TestPaper tp1=tps.getPaperService(tp);
		//获取到试卷对象后,添加试题
		tps.addDefaultPaperService(tp1);
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("flag", 1);
		map.put("msg","添加成功");	
		JSONObject jsonObject=JSONObject.fromObject(map);
		String jsonStr= jsonObject.toString();
		inputStream=new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
		return SUCCESS;
	}
	
	
	//查询试题
	public String getShiTi() throws UnsupportedEncodingException{
		PageUtil pu=new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);
		ShiTi st=new ShiTi();
		st.setType(type);
		inputStream=tps.getShiTiService(st, pu);
		return SUCCESS;		
	}
	
	//保存试卷试题
	public String baocunPaper() throws UnsupportedEncodingException{
		tps.savePaperShiTiService(qpaper);//保存手动添加试题
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("flag", 1);
		map.put("msg","添加成功");
		JSONObject jsonObject=JSONObject.fromObject(map);
		String jsonStr= jsonObject.toString();
		inputStream=new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
		return SUCCESS;	
	}
	
	
	//======================添加考试班级=====================================================
	/**
	 * 添加考试班级action
	 */
	public String addTestClass() throws UnsupportedEncodingException, ParseException{
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("flag", 1);
		map.put("msg","保存成功");
		tps.addTestStudents(tp,myClass);
		
		JSONObject jsonObject=JSONObject.fromObject(map);
		String jsonStr= jsonObject.toString();
		inputStream=new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
		return SUCCESS;	
	}

	//=========================添加考试班级=====================================================
	
	
	
	
	

	public Admin getTeacher() {
		return teacher;
	}

	public void setTeacher(Admin teacher) {
		this.teacher = teacher;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	
	
	public TestPaper getTp() {
		return tp;
	}
	public void setTp(TestPaper tp) {
		this.tp = tp;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}

	public String getQpaper() {
		return qpaper;
	}

	public void setQpaper(String qpaper) {
		this.qpaper = qpaper;
	}

	public String getSetupDateTest() {
		return setupDateTest;
	}

	public void setSetupDateTest(String setupDateTest) {
		this.setupDateTest = setupDateTest;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	public MyClass getMyClass() {
		return myClass;
	}

	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
	}

	public String getClassNum() {
		return classNum;
	}

	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	
}
