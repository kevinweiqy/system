package com.entor.action.testScore;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.entor.dao.StudentDao;
import com.entor.dao.TestPaperDao;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.service.TestScoreService;
import com.entor.utils.JsonConfigUtils;
import com.entor.utils.JsonValueProcessorImpl;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;


@Controller
@Scope("prototype")//变成多线程多实例
public class TestScoreAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ServletRequestAware{

	private TestScore testScore;
	@Autowired @Qualifier("testScoreServiceImpl")
	private TestScoreService testScoreService;

	private InputStream inputStream;
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private TestPaperDao testPaperDao;
	private int page;//第几页
	private int rows;//每页的记录数 
	private int paperid;//
	private int studentid;
	private Map<String,Object> request;
    private Map<String,Object> session;
    private Map<String,Object> application;
    private HttpServletRequest request2;
	//外部声明
   Map<String,Object> map=new HashMap<String,Object>();
	private HttpSession session1;
	
	//带分页的查询antion
	public String getTestScoreListByPage() throws UnsupportedEncodingException{
		PageUtil pu= new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);
		 inputStream=testScoreService.getTestScoreListByPage(testScore, pu);
		return SUCCESS;
	}
	
	//添加
	public String addTestScore() 
	throws UnsupportedEncodingException{
		try {
			Student stu=studentDao.get(Student.class,studentid);
			TestPaper tp=testPaperDao.get(TestPaper.class, paperid);
			testScore.setStu(stu);
			testScore.setTp(tp);
			
			testScoreService.addTestScore(testScore);
		map.put("flag", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("flag", 0);
		}//map转换成json的字符串
		JSONObject jsonObj = JSONObject.fromObject(map);
		inputStream = new ByteArrayInputStream(
				jsonObj.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	
	//删除
	public String deleteTestScore() 
	throws UnsupportedEncodingException{
		try {
			testScoreService.deleteTestScore(testScore);
			map.put("flag", 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				map.put("flag", 0);
			}//map转换成json的字符串
			JSONObject jsonObj = JSONObject.fromObject(map);
			inputStream = new ByteArrayInputStream(
					jsonObj.toString().getBytes("utf-8"));
		return SUCCESS;
	}

	//根据id获取一条考试成绩信息
	public String getTestScoreById() throws UnsupportedEncodingException{		
		inputStream=testScoreService.getTestScoreById(testScore.getId());				
		//map转化为字符串
//		JSONObject jsonObject = JSONObject.fromObject(map);
//		inputStream = new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	
	//更新
	public String updateTestScore() 
	throws UnsupportedEncodingException{
		try {
			
			testScoreService.updateTestScore(testScore);
			map.put("flag", 1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				map.put("flag", 0);
			}//map转换成json的字符串
			JSONObject jsonObj = JSONObject.fromObject(map);
			inputStream = new ByteArrayInputStream(
					jsonObj.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	
	public String getTestScoreByPage() throws UnsupportedEncodingException{
		HttpServletRequest request=ServletActionContext.getRequest();
		session1=request.getSession();
		Student student=(Student)session1.getAttribute("student");
		testScore.setStu(student);
		PageUtil pu=new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);		
		inputStream=testScoreService.getTestScoreListByPage(testScore, pu);
		return SUCCESS;
	}
	
	/**
	 * 查询学生成绩
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String getTestScores() throws UnsupportedEncodingException{
		Student stu=(Student)session.get("student");
		inputStream=testScoreService.getStudentScore(stu);
		return SUCCESS;
	}
	
	

	public TestScore getTestScore() {
		return testScore;
	}

	public void setTestScore(TestScore testScore) {
		this.testScore = testScore;
	}

	public TestScoreService getTestScoreService() {
		return testScoreService;
	}

	public void setTestScoreService(TestScoreService testScoreService) {
		this.testScoreService = testScoreService;
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

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public int getPaperid() {
		return paperid;
	}

	public void setPaperid(int paperid) {
		this.paperid = paperid;
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	public void setRequest(Map<String, Object> request) {
		this.request = request;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request2=request;
		
	}

}
