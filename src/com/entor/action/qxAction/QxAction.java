package com.entor.action.qxAction;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entor.dao.QxInfoDao;
import com.entor.model.JS_XX;
import com.entor.model.QX_INFO;
import com.entor.service.AdminService;
import com.entor.service.impl.QX_INFOServiceImpl;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;

@Controller("qxAction") @Scope("prototype")
public class QxAction extends ActionSupport {
	private QX_INFO qx;
	@Autowired @Qualifier("adminServiceImpl")
	private AdminService as;
	@Autowired @Qualifier("qxInfoDaoImpl")
	private QxInfoDao qd;
//	@Autowired 
//	private QX_INFOServiceImpl qi;
//	
	private InputStream inputStream;
	private HttpSession session;
	public QX_INFO getQx() {
		return qx;
	}
	public void setQx(QX_INFO qx) {
		this.qx = qx;
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

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	private int page;//第几页
	private int rows;//每页的记录数
	private int pageSize;//转过来
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getJson() throws UnsupportedEncodingException{
		HttpServletRequest request=
			ServletActionContext.getRequest();
		session = request.getSession(); 
		String loginName = (String) session.getAttribute("loginName");
		inputStream=as.getQxList(loginName,id);
		return SUCCESS;		
	}
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	
}
