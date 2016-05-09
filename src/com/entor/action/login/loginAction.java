package com.entor.action.login;


import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.entor.dao.StudentDao;
import com.entor.model.Admin;
import com.entor.model.Student;
import com.entor.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
@Controller("loginAction") @Scope("prototype") 
public class loginAction extends ActionSupport{
	@Autowired @Qualifier("adminServiceImpl")
	private AdminService as;
	@Autowired @Qualifier("studentDaoImpl")
	private StudentDao sd;	
	private String loginName;
	private String pwd;
	private int sel;
	private InputStream inputStream;
	private HttpSession session;
	
	public String login() throws UnknownHostException{	
		HttpServletRequest request=
			ServletActionContext.getRequest();
		session = request.getSession();
		InetAddress ia =null;
		String LocaLip = ia.getLocalHost().getHostAddress(); 
		session.setAttribute("LocaLip", LocaLip);
		String LocaName = ia.getLocalHost().getHostName();
		session.setAttribute("LocaName", LocaName);
		Date sDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String timeNow = sdf.format(sDate);
		
		session.setAttribute("timeNow", timeNow);
		if(sel==0){
			Student stu= sd.getStudent(loginName,pwd);
			if(stu!=null){
				session.setAttribute("student", stu);
				session.setAttribute("sName", stu.getStudentname());
				return "successStudent";
			}else{
				session.setAttribute("error", "账号密码错误");
				return "input";
			}
		}else if(sel==1){
			boolean fag = as.getBoolean(loginName,pwd);
			if(fag){
				session.setAttribute("loginName", loginName);
				Admin admins =  as.getAdminName(loginName);
				String Aname = admins.getAdmin_name();
				session.setAttribute("Admin", admins);
				session.setAttribute("Aname", Aname);
				return "teacher";
			}else{
				session.setAttribute("error", "账号密码错误");
				return "input";
			}
		}
		return "input";		
	}

	
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public int getSel() {
		return sel;
	}
	public void setSel(int sel) {
		this.sel = sel;
	}
	
}
