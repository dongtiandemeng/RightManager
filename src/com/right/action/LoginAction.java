package com.right.action;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.chen.HelloLog4j;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.right.common.MySqlSession;
import com.right.dao.OnlineUserDao;
import com.right.dao.UserDAO;
import com.right.mapper.OnlineUser;
import com.right.mapper.User;


public class LoginAction extends ActionSupport{
	private static Logger logger = Logger.getLogger(LoginAction.class);  
	private User user;
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
//		logger.error("username"+getUsername());
//		logger.error("pwd"+getPwd());
		user = dao.validateUser(username, pwd);
//		logger.error("user = "+user);
		if(user!=null){
//		if(retval ==  true){
			ActionContext ac = ActionContext.getContext();
			Map<String,Object> session = ac.getSession();
			session.put("userinfo",user.getName());	
			System.out.println("LoginAction session username"+user.getName());
			
			//不存在本地的列表了，直接存到数据库了
			
			
/*			OnlineUserDao onlineUserDao = new OnlineUserDao();
			OnlineUser onlineUser = onlineUserDao.select(user.getName());
			logger.info("LoginAction select");
			if(onlineUser==null){
				Date now = new Date(); 
//			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH:mm:ss");//可以方便地修改日期格式
//			String hehe = dateFormat.format( now ); 
//			Date date = new Date(hehe);
				onlineUserDao.insert(username, now);
				MySqlSession.commit();				
			}else{
				return "repeat";
			}
			*/
			return SUCCESS;
		}			
		else
			return ERROR;
		
	}
	
//	public String exit(){
//		logger.info("LoginAction delete");
//		OnlineUserDao onlineUserDao = new OnlineUserDao();
//		onlineUserDao.delete(user.getName());
//		MySqlSession.commit();
//		return "reLogin";
//	}
	
}
