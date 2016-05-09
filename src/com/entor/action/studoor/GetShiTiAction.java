package com.entor.action.studoor;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import net.sf.json.JSONObject;
import net.sf.json.JSONString;
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

import com.entor.model.ShiTi;
import com.entor.model.Student;
import com.entor.model.TestPaper;
import com.entor.model.TestScore;
import com.entor.service.studoor.SelectTestPaperServices;
import com.entor.utils.JsonConfigUtils;
import com.entor.utils.JsonValueProcessorImpl;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;


@Controller("getShiTiAction")
@Scope("prototype")
public class GetShiTiAction extends ActionSupport
implements RequestAware,SessionAware,ApplicationAware,ServletRequestAware{
	@Autowired
	@Qualifier("selectTestPaperServicesImpl")
	private SelectTestPaperServices selectTestPaperServices;
	private InputStream inputStream;
	private Map<String, Object> map = new HashMap<String, Object>();
	private int id;
	private int page;// 第几页
	private int rows;// 每页的记录数
	private Map<String,Object> request;
    private Map<String,Object> session;
    private Map<String,Object> application;
    private HttpServletRequest request2;
    private String daAn;

    //获取考试试题
	public String getTestPaperShiTiList()  throws UnsupportedEncodingException {
		PageUtil pu = new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);
		Student student=(Student) session.get("student");
		//获取试题集合
		Map<String,List<ShiTi>> map=selectTestPaperServices.getTestPaperShiTiList(student.getId());
		//获取试卷信息
		TestPaper tp1=selectTestPaperServices.getTestPaperService(student.getId());
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		//存试题到session
		session.setAttribute("shiti", map);
		//存试卷信息到session
		session.setAttribute("shijuan", tp1);
		return "su";
	}
	
	
	
    //获取考试答案
	public String jiSuanScore()  throws UnsupportedEncodingException {
		Map<String,List<ShiTi>> map1=(Map<String, List<ShiTi>>) session.get("shiti");
		Student student=(Student) session.get("student");//获取学生
		Map<String,Object> map2= new HashMap<String, Object>();
		map2.put("daAn", daAn);
		map2.put("stu", student);
		TestPaper test=(TestPaper) session.get("shijuan");
		TestScore ts=selectTestPaperServices.addTestAnswer(map1,map2,test);
        //从session取到学生信息，根据学生信息找到试卷信息(通过考试成绩表，找到没有成绩的那张试卷)
		JSONObject obj=new JSONObject();
		obj.put("score",ts.getScore());
		String str=obj.toString();
		System.out.println(str);
		inputStream=new ByteArrayInputStream(str.getBytes("utf-8"));
		return SUCCESS;
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
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
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

	public String getDaAn() {
		return daAn;
	}

	public void setDaAn(String daAn) {
		this.daAn = daAn;
	}
	
	

	
}
