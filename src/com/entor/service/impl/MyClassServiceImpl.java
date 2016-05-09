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

import com.entor.dao.MyClassDao;
import com.entor.model.MyClass;
import com.entor.model.Student;
import com.entor.service.MyClassService;
import com.entor.utils.JsonConfigUtils;
import com.entor.utils.PageUtil;
@Service
public class MyClassServiceImpl implements MyClassService{
	
	@Autowired @Qualifier("myClassDaoImpl")
	
	private MyClassDao myClassDao;
	
	public void addMyClass(MyClass myClass) {
		// TODO Auto-generated method stub
		myClassDao.save(myClass);
	}

	public void deleteMyClass(MyClass myClass) {
		// TODO Auto-generated method stub
		myClassDao.delete(myClass);
	}


	public MyClass gatMyClass(int id) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		MyClass myClass= myClassDao.get(MyClass.class, id);
		return  myClass;
	}

	public MyClass gatMyClass_wo(int id) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		MyClass myClass= myClassDao.get(MyClass.class, id);
		return  myClass;
	}

	public void updateMyClass(MyClass myClass) {
		// TODO Auto-generated method stub
		myClassDao.update(myClass);
	}

	//分页的方法
	public InputStream getMyClassListJsonByPage(MyClass myClass, PageUtil pu) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		//获取总的记录数,调用底层dao
		long totalRecords = 
			myClassDao.getTotolRecords(myClass);//实际上是调用dao层获取的
		//填充总的记录数
		pu.setTotalRecords(totalRecords);
		//获取分页的集合对象，调用底层dao			
		List<MyClass> list = myClassDao.getMyClassListByPage(myClass, pu);
		//转换数据格式,把格式转换成:{"total":100,"rows":[{},{}]}
		Map<String,Object> map = 
			new HashMap<String,Object>();
		map.put("total", pu.getTotalRecords());
		map.put("rows", list);
		JSONObject jsonObject=JSONObject.fromObject(map);//转成json数组
		String jsonStr= jsonObject.toString();
        System.out.println(jsonStr);
		return new ByteArrayInputStream(jsonStr.getBytes("utf-8"));
	}

	

	
    
 
	

	

}
