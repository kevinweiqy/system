package com.entor.interceptor;

import java.util.Map;

import javax.script.Invocable;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptorNew implements Interceptor{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	//初始化，只会执行一次，过滤器
	public void init() {
		// TODO Auto-generated method stub
		ServletActionContext.getServletContext();		
	}
	//核心方法，拦截的过程在这里实现
	//判断用户是否登录。
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		Object userName = session.get("loginName");
		Object students = session.get("sName");		
		if(userName==null&&students==null){			
			//获取当前请求名字空间
			String namespace = arg0.getProxy().getNamespace();
			//判断请求的是哪个action
			String actionName = arg0.getProxy().getActionName();
			if("/login/login.action".equals(namespace+"/"+actionName+".action")){
				//第一次提交的anction必须放行，还有web.xml里面配置有不拦截的。的
				return arg0.invoke();
			}
			return "logins";//转到登录视图
		}else{
			//放行
			return arg0.invoke();//调用invoke方法放行；
		}
	}
	
}
