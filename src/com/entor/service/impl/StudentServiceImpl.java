package com.entor.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.entor.dao.StudentDao;
import com.entor.model.Student;
import com.entor.service.StudentService;
import com.entor.utils.JsonConfigUtils;
import com.entor.utils.JsonValueProcessorImpl;
import com.entor.utils.PageUtil;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService{
		@Autowired @Qualifier("studentDaoImpl")
		private StudentDao studentDao;

		//添加
		public void studentAdd(Student student)  {
			// TODO Auto-generated method stub
			studentDao.save(student);
			//throw new Exception("添加商品异常");
		}

		//删除
		public void Studentdelete(Student student) {
			// TODO Auto-generated method stub
			studentDao.delete(student);
		}

		//更新
		public void Studentupdate(Student student) {
			// TODO Auto-generated method stub
			studentDao.update(student);
		}
		
		//根据id获取一个商品信息
		public Student getStudent(int id) {
			return studentDao.get(Student.class, id);
		}

		//根据条件获取一个商品列表
		public List<Student> getAllStudentList(Student student) {
			// TODO Auto-generated method stub
			return studentDao.getAllStudentList();
		}

		//
		public InputStream getStudentJsonByPage(Student student, PageUtil pu) throws UnsupportedEncodingException {
			// TODO Auto-generated method stub
			//获取总的记录数,调用底层dao
			long totalRecords = 
				studentDao.getTotalRecords(student);//实际上是调用dao层获取的
			//填充总的记录数
			pu.setTotalRecords(totalRecords);
			//获取分页的集合对象，调用底层dao				
			List<Student> list = 
				studentDao.getStudentListByPage(student, pu);
			
			JsonConfig cfg=JsonConfigUtils.getNoCycleJsonConfig();
			cfg.registerJsonValueProcessor(java.sql.Date.class, new JsonValueProcessorImpl());
			
			//转换数据格式,把格式转换成:{"total":100,"rows":[{},{}]}
			Map<String,Object> map = 
				new HashMap<String,Object>();
			map.put("total", pu.getTotalRecords());
			map.put("rows", list);
			
			JSONObject jsonObject = JSONObject.fromObject(map,cfg);
			String jsonStr = jsonObject.toString();
			System.out.println(jsonStr);
			//以流的形式返回一个json的字符串,并设置编码格式
			return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
		}

		public InputStream getonesStudent(int id) throws UnsupportedEncodingException {
			// TODO Auto-generated method stub
			Student student=studentDao.get(Student.class, id);
			System.out.println(student.getSex()+student.getStudentname()+student.getStudentNumber());
			JsonConfig cfg = JsonConfigUtils.getNoCycleJsonConfig();
			cfg.registerJsonValueProcessor(java.sql.Date.class,
					new JsonValueProcessorImpl());
			//转换成json的字符串
			JSONObject jsonObject = 
				JSONObject.fromObject(student, cfg);
			String jsonStr = 
				jsonObject.toString();
			System.out.println(jsonStr);
			return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
		
		}
		
	}		
	
