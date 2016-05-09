package com.entor.action.shiti;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entor.model.Admin;
import com.entor.model.Rightorwrong;
import com.entor.model.Select;
import com.entor.model.ShiTi;
import com.entor.service.ShiTiService;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller@Scope("prototype")
public class ShiTiAction extends ActionSupport{

	private Rightorwrong rightorwrong;
	private Select select;
	@Autowired
	private ShiTiService shiTiService;
	private InputStream inputStream;
	private int page;//第几页
	private int rows;//每页记录数
	
	
	
	public String addShiTi() throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("flag", 1);
		try{
			if(rightorwrong!=null){
			     shiTiService.addShiTi(rightorwrong);
			}else if(select!=null){
				 shiTiService.addShiTi(select);
			}
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
	
	public String deleteShiTi() throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("flag", 1);
		try{
			if(rightorwrong!=null){
			shiTiService.deleteShiTi(rightorwrong);
			}else if(select!=null){
				shiTiService.deleteShiTi(select);
			}
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
	
	public String updateShiTi() throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("flag", 1);
		try{
			if(rightorwrong!=null){
				shiTiService.updateShiTi(rightorwrong);
			}else if(select!=null){
				shiTiService.updateShiTi(select);
			}
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
	public String getShiti() throws UnsupportedEncodingException{
		try{
			if(rightorwrong!=null){
			rightorwrong = shiTiService.getRightorwrong(rightorwrong.getId());	
			}else if(select!=null){
				select = shiTiService.getSelect(select.getId());
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		if(rightorwrong!=null){
		JSONObject jsonObject=JSONObject.fromObject(rightorwrong);
		inputStream=new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		}else if(select!=null){
			JSONObject jsonObject=JSONObject.fromObject(select);
			inputStream=new ByteArrayInputStream(jsonObject.toString().getBytes("utf-8"));
		}
		return SUCCESS;
	}
	
	//按条件查询并分页
	public String getShiTiListByPage() throws UnsupportedEncodingException{
		PageUtil pu = new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows);
		if(rightorwrong!=null){
		    inputStream = shiTiService.getShiTiListByPage(rightorwrong, pu);
		}else if(select!=null){
			inputStream = shiTiService.getShiTiListByPage(select, pu);
		}
		return SUCCESS;
	}
	
	
	public Rightorwrong getRightorwrong() {
		return rightorwrong;
	}
	public void setRightorwrong(Rightorwrong rightorwrong) {
		this.rightorwrong = rightorwrong;
	}
	public Select getSelect() {
		return select;
	}
	public void setSelect(Select select) {
		this.select = select;
	}
	public ShiTiService getShiTiService() {
		return shiTiService;
	}
	public void setShiTiService(ShiTiService shiTiService) {
		this.shiTiService = shiTiService;
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
}
