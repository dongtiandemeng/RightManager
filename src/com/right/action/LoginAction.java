package com.right.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.right.dao.UserDAO;
import com.right.mapper.User;

public class LoginAction extends ActionSupport{

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	private String username;
	private String pwd;
	public LoginAction() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginAction");
		UserDAO dao = new UserDAO();
//		boolean retval = dao.validateUser(username, pwd);
		User user = dao.validateUser(username, pwd);
		if(user!=null){
//		if(retval ==  true){
			ActionContext ac = ActionContext.getContext();
			Map<String,Object> session = ac.getSession();
			session.put("userinfo",username);	
			System.out.println("LoginAction session");
			return SUCCESS;
		}			
		else
			return ERROR;
		
	}
	
}
