package com.right.action;

import java.util.List;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.right.common.MySqlSession;
import com.right.dao.DictDao;
import com.right.dao.RoleDao;
import com.right.dao.UserDAO;
import com.right.mapper.Role;
import com.right.mapper.User;

public class UserAction extends ActionSupport{

	private List<User> userList;
	
	private User user;
	private Integer id;
	private List<Integer> chk_id;
	private List<Role> roleList;
	
	private static Logger logger = Logger.getLogger(UserAction.class);
	

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Integer> getChk_id() {
		return chk_id;
	}

	public void setChk_id(List<Integer> chk_id) {
		this.chk_id = chk_id;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public UserAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute() throws Exception {
		try {
			UserDAO uDao = new UserDAO();
			userList = uDao.selectUser();
			MySqlSession.commit();
			
			return SUCCESS;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			MySqlSession.rollback();
		}
		
		return null;
	}
	
	public String insert(){
		
		UserDAO userDao =new UserDAO();
		roleList=userDao.selectAllRole();
			return "insert";
	}
	
	public String save() throws Exception{
		
		try {
			logger.info("UserAction save");
			UserDAO userDao = new UserDAO();
			userDao.save(user);
			
			//对那个t_base_user_role表进行操作
			
			MySqlSession.commit();
			return "ok";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	
	public String modify() throws Exception{
		UserDAO userDao = new UserDAO();
		user=userDao.getUserByID(id);
		
		//修改这个地方要改，id对应的那个role，还要把所有的role修改
		//这里是查，不是改
		roleList=userDao.selectAllRole();
		return "modify";
	}
	
	public String update() throws Exception{

//		logger.info("UserAction update user id"+user.getId());
//		logger.info("UserAction update user role id"+user.getRole().getId());
		UserDAO userDao = new UserDAO();
		userDao.update(user);
		
		MySqlSession.commit();
		return "ok";
	}
	
	public String redirectUserDelete(){
		return "delete";
	}
	
	public String delete() throws Exception{
		UserDAO userDao = new UserDAO();
		logger.info("UserAction delete chk_id");
		logger.info(chk_id);
		userDao.batchDelete(chk_id);
		
		//还要删除t_base_user_role的关联
		MySqlSession.commit();
		return "ok";

	}

}
