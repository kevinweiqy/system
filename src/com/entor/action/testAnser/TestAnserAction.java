package com.entor.action.testAnser;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entor.model.Student;
import com.entor.model.TestAnser;
import com.entor.model.TestPaper;
import com.entor.service.TestAnserService;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;
@Controller("testAnserAction")
@Scope("prototype")
public class TestAnserAction extends ActionSupport{

	private TestAnser testAnser;
	@Autowired@Qualifier("testAnserServiceImpl")
	private TestAnserService testAnserService;
	private InputStream inputStream;
	private int page;
	private int rows;


	public TestAnser getTestAnser() {
		return testAnser;
	}


	public void setTestAnser(TestAnser testAnser) {
		this.testAnser = testAnser;
	}


	public TestAnserService getTestAnserService() {
		return testAnserService;
	}


	public void setTestAnserService(TestAnserService testAnserService) {
		this.testAnserService = testAnserService;
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


	public String getTestAnserByPage() throws UnsupportedEncodingException{
//		String a[]=id.split(",");
//		Student student = new Student();
//		student.setId(Integer.parseInt(a[0]));
//		TestPaper testPaper = new TestPaper();
//		testPaper.setId(Integer.parseInt(a[1]));
//		testAnser.setStudent(student);
//		testAnser.setTestPaper(testPaper);
		PageUtil pu=new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);
		inputStream = testAnserService.getTestAnserListByPage(testAnser, pu);
		return SUCCESS;
	}
	
	
}
