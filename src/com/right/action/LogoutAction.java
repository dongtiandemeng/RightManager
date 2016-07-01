package com.right.action;

import java.util.Map;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.right.common.MySqlSession;
import com.right.dao.OnlineUserDao;
import com.right.mapper.User;

public class LogoutAction extends ActionSupport {
	private static Logger logger = Logger.getLogger(LogoutAction.class);
	public LogoutAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String execute() throws Exception{
		logger.info("LogoutAction delete");
		OnlineUserDao onlineUserDao = new OnlineUserDao();
		User user = new User();
		
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = ac.getSession();
		session.get("userinfo");
		logger.info("LoginAction delete user.getName()"+session.get("userinfo"));
		
		onlineUserDao.delete((String)session.get("userinfo"));
		MySqlSession.commit();
		return "reLogin";
	}

}
