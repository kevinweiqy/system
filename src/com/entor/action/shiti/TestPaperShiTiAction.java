package com.entor.action.shiti;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entor.model.TestPaperShiTi;
import com.entor.service.TestPaperShiTiService;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller@Scope("prototype")
public class TestPaperShiTiAction extends ActionSupport{

	private TestPaperShiTi testPaperShiTi;
	@Autowired
	private TestPaperShiTiService testPaperShiTiService;
	private InputStream inputStream;
	private int page;//第几页
	private int rows;//每页记录数
	public TestPaperShiTi getTestPaperShiTi() {
		return testPaperShiTi;
	}
	public void setTestPaperShiTi(TestPaperShiTi testPaperShiTi) {
		this.testPaperShiTi = testPaperShiTi;
	}
	public TestPaperShiTiService getTestPaperShiTiService() {
		return testPaperShiTiService;
	}
	public void setTestPaperShiTiService(TestPaperShiTiService testPaperShiTiService) {
		this.testPaperShiTiService = testPaperShiTiService;
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
	
	public String addTestPaperShiTi() throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("flag", 1);
		try{
			testPaperShiTiService.addTestPaperShiTi(testPaperShiTi);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("flag", 0);
		}
		//map转化为字符串
		JSONObject jsonObject = JSONObject.fromObject(map);
		inputStream = new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	
	public String deleteTestPaperShiTi() throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("flag", 1);
		try{
			testPaperShiTiService.deleteTestPaperShiTi(testPaperShiTi);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("flag", 0);
		}
		//map转化为字符串
		JSONObject jsonObject = JSONObject.fromObject(map);
		inputStream = new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	
	public String updateTestPaperShiTi() throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("flag", 1);
		try{
			testPaperShiTiService.updateTestPaperShiTi(testPaperShiTi);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("flag", 0);
		}
		//map转化为字符串
		JSONObject jsonObject = JSONObject.fromObject(map);
		inputStream = new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	
	//获得一道试题
	public String getTestPaperShiti() throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("flag", 1);
		try{
			testPaperShiTiService.getTestPaperShiTi(testPaperShiTi.getId());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("flag", 0);
		}
		//map转化为字符串
		JSONObject jsonObject = JSONObject.fromObject(map);
		inputStream = new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	
	//按条件查询并分页
	public String getTestPaperShiTiListByPage() throws UnsupportedEncodingException{
		PageUtil pu = new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);
		testPaperShiTiService.getTestPaperShiTiListByPage(testPaperShiTi, pu);
		return SUCCESS;
	}
}
