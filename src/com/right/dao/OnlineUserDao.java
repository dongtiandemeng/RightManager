package com.right.dao;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.right.action.LoginAction;
import com.right.common.MySqlSession;
import com.right.mapper.OnlineUser;
import com.right.mapper.OnlineUserMapper;

public class OnlineUserDao {
	private static Logger logger = Logger.getLogger(OnlineUserDao.class);
	public OnlineUserDao() {
		// TODO Auto-generated constructor stub
	}
	public void insert(String username,Date onlineTime){
		try {
			logger.info("Login dao onlineUser  ");
			SqlSession session = MySqlSession.getSqlSeesion();
			OnlineUserMapper obj = session.getMapper(OnlineUserMapper.class);
			obj.insertOnlineUser(username, onlineTime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public OnlineUser select(String username){
		try {
			logger.info("Login dao onlineUser select ");
			SqlSession session = MySqlSession.getSqlSeesion();
			OnlineUserMapper obj = session.getMapper(OnlineUserMapper.class);
			return obj.selectOnlineUser(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete(String username){
		try {
			logger.info("Login dao onlineUser delete ");
			SqlSession session = MySqlSession.getSqlSeesion();
			OnlineUserMapper obj = session.getMapper(OnlineUserMapper.class);
			obj.deleteOnlineUser(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
