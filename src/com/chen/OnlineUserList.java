package com.chen;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionContext;
import com.right.action.LoginAction;

public class OnlineUserList implements HttpSessionAttributeListener,HttpSessionListener,
ServletContextListener{
	
	private static Logger logger = Logger.getLogger(OnlineUserList.class);  
	private ServletContext app =null;
	public OnlineUserList() {
		// TODO Auto-generated constructor stub
		System.out.println("OnlineUserList");
	}
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("contextInitialized");
		this.app =arg0.getServletContext();
		this.app.setAttribute("online", new TreeSet());
		
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("attributeAdded");
		Set all = (Set) this.app.getAttribute("online");
		//判断是否要添加Session,如果没有就添加，如果有就不要添加,但是Set是不会添加重复的
		
//		Iterator iter = all.iterator();
//		while(iter.hasNext()){
//			String username=(String)iter.next();
//			if(name.equals(username)){				
//				System.out.println("请不要重复登录");
//				RequestDispatcher rd = request.getRequestDispatcher("repeat.html");
//				rd.forward(request, response);
//			}else{
//				System.out.println("用户第一次登录");
//				RequestDispatcher rd = request.getRequestDispatcher("list.jsp");
//				rd.forward(request, response);
//			}				
//		}
		
		//end
		
		ActionContext ac = ActionContext.getContext();
		Map<String,Object> session = ac.getSession();
		session.get("userinfo");
		
		
		//is not 软件142
		
		System.out.println("add getValue"+arg0.getValue());
		all.add(arg0.getValue());
		this.app.setAttribute("online", all);
		
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("attributeRemoved");
		Set all = (Set)this.app.getAttribute("online");
		all.remove(arg0.getValue());
		this.app.setAttribute("online", all);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		//没有执行这个方法，导致每一次都是重复登录
		//执行这个方法前提是session失效，关掉浏览器session就失效吗，好像不是，
		//还要考虑另一个问题，就是当用户没有操作时也要让session失效。
		
		//要让session失效，必须调用session.invalidate或者设置超时
		System.out.println("sessionDestroyed");
		Set all = (Set) this.app.getAttribute("online");
		System.out.println("sessionDestroyed arg0.getSession().getAttribute"+arg0.getSession().getAttribute("userinfo"));
		
		if(arg0.getSession().getAttribute("userinfo")!=null){		
			all.remove(arg0.getSession().getAttribute("userinfo"));
			this.app.setAttribute("online", all);
			System.out.println("从列表中删除这个用户");
		}
		
	}
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
