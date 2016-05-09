package com.entor.action.student;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.entor.dao.MyClassDao;
import com.entor.model.MyClass;
import com.entor.model.QX_INFO;
import com.entor.model.Student;

import com.entor.service.StudentService;
import com.entor.utils.JsonConfigUtils;
import com.entor.utils.JsonValueProcessorImpl;
import com.entor.utils.PageUtil;
import com.opensymphony.xwork2.ActionSupport;
	
//控制层纳入spring容器用@Controller
@Controller//("studentAction")
@Scope("prototype")
public class StudentAction extends ActionSupport implements RequestAware,SessionAware,ApplicationAware,ServletRequestAware{
	private Student student;
	
	@Autowired @Qualifier("studentServiceImpl")
	private StudentService studentService;
	private InputStream inputStream;
	
	@Autowired 
	private MyClassDao myClassDao;
	
	private int page;//第几页
	private int rows;//每页记录数
	private int myClassid;
	private Map<String,Object> request;
    private Map<String,Object> session;
    private Map<String,Object> application;
    private HttpServletRequest request2;
	

	//添加
	public String StudentAdd() throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String,Object>(); 
		try {
		MyClass myClass=myClassDao.get(MyClass.class, myClassid);
		student.setMyClass(myClass);
		studentService.studentAdd(student);
			//添加成功放入一个1
			map.put("flag", 1);
			System.out.println("添加成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//有异常放入一个0
			map.put("flag", 0);
			System.out.println("添加失败");
		}
		//map转化成json的字符串,然后转成一个流
		JSONObject jsonObj = 
			JSONObject.fromObject(map);
		inputStream = new ByteArrayInputStream(
				jsonObj.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	//更新
	public String Studentupdate() throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			MyClass myClass=myClassDao.get(MyClass.class, myClassid);
			student.setMyClass(myClass);
			studentService.Studentupdate(student);
			//更新成功放入一个1
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			map.put("flag", 1);
			System.out.println("更新成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//有异常放入一个0
			map.put("flag", 0);
			System.out.println("更新失败");
		}
		//map转化成json的字符串,然后转成一个流
		JSONObject jsonObj =
			JSONObject.fromObject(map);
		inputStream = new ByteArrayInputStream(
				jsonObj.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	//删除
	public String Studentdelete() throws UnsupportedEncodingException{
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			studentService.Studentdelete(student);
			//删除成功放入一个1
			map.put("flag", 1);
			System.out.println("删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//有异常放入一个0
			map.put("flag", 0);
			System.out.println("删除失败");
		}
		//map转化成json的字符串,然后转成一个流
		JSONObject jsonObj =
			JSONObject.fromObject(map);
		inputStream = new ByteArrayInputStream(
				jsonObj.toString().getBytes("utf-8"));
		return SUCCESS;
	}
	
	
	//拿到一个学生对象
	public String getonesstudent() 
	throws UnsupportedEncodingException{
		inputStream= studentService.getonesStudent(student.getId());
		return SUCCESS;
	}
	//分页
	public String getStudentJsonByPage() throws UnsupportedEncodingException{
		PageUtil pu = new PageUtil();
		pu.setPageNo(page);
		pu.setSize(rows); 
		inputStream = 
			studentService.getStudentJsonByPage(student, pu);
		
		return SUCCESS;
	}
	
	
	
	public String getStudentSession() throws UnsupportedEncodingException{
//		Student stu= (Student) session.get("student");		
//		List<Student> list = new ArrayList<Student>();
//		list.add(stu);
//		JSONArray ja = JSONArray.fromObject(list);
//		String jstr = ja.toString();		                                        
//		inputStream = new ByteArrayInputStream(jstr.getBytes("utf-8"));
		return SUCCESS;
		
	}

	public String updatePassword() throws UnsupportedEncodingException{
		Student stu=(Student)session.get("student");
		String password=student.getStudentpassword();
		stu.setStudentpassword(password);
		studentService.Studentupdate(stu);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("flag", 1);
		map.put("cheng", "修改密码成功");
		JSONObject jsonObject=JSONObject.fromObject(map);
		String json = jsonObject.toString();		                                        
		inputStream = new ByteArrayInputStream(
				json.toString().getBytes("utf-8"));
		return SUCCESS;
	}



	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
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

	public int getMyClassid() {
		return myClassid;
	}

	public void setMyClassid(int myClassid) {
		this.myClassid = myClassid;
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