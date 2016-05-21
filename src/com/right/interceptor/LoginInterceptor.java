package com.right.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = ServletActionContext.getRequest();
		String path = req.getServletPath();
		System.out.println("getServletPath  "+path);
		if(path.contains("login.action"))
			return arg0.invoke();
		Map<String,Object> session = ActionContext.getContext().getSession();
		System.out.println("LoginInterceptor");
		if(session.get("userinfo")!=null){
			System.out.println("session.get"+session.get("userinfo"));
			return arg0.invoke();
		}else{
			System.out.println("return");
			return "login";
		}
		
	}

}
