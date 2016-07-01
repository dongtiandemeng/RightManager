package com.right.dao;
import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.right.action.LoginAction;
import com.right.common.MySqlSession;
import com.right.common.SessionFactory;
import com.right.mapper.Dict;
import com.right.mapper.DictMapper;
import com.right.mapper.DictType;
import com.right.mapper.DictTypeMapper;
import com.right.mapper.Role;
import com.right.mapper.User;
import com.right.mapper.UserMapper;
/**
 * 处理用户信息
 * 
 * @author Administrator
 * 
 */
public class UserDAO {
//	public static final String url = "jdbc:mysql://172.16.123.161/rightdb";  
//    public static final String name = "com.mysql.jdbc.Driver";  
//    public static final String user = "root";  
//    public static final String password = "123456";  
  
//    public Connection conn = null;  
	



	/**
	 * 处理用户登录信息
	 * 
	 * @return 正确返回：true 错误返回：false
	 */
//	public boolean validateUser(String name, String pwd) {
//		try {
//			// 连接数据库
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con = DriverManager.getConnection(url,user,password);
//			// 提交验证查询语句
//			String sql = "select * from t_base_user where loginname=? and password=?";
//			PreparedStatement pst = con.prepareStatement(sql);
//			pst.setString(1, name);
//			pst.setString(2, pwd);
//			ResultSet rs = pst.executeQuery();
//			// 根据返回结果返回验证结果
//			if(rs.next())
//				return true;
//			else
//				return false;
//			
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//		return false;
//	}
    
    public User validateUser(String name,String pwd){
//    	System.out.println("UserDAO");
//    	logger.error("UserDAO");
//    	SqlSession session = SessionFactory.getSessionFactory().openSession();
//    	Map<String ,Object> param = new HashMap<String,Object>();
//    	param.put("username", name);
//    	param.put("password", pwd);
//    	
//    	User user = session.selectOne("com.right.mapper.UserMapper.validateUser",param);
//    	
//    	System.out.println("UserDAO user"+user);
//    	logger.error("UserDAO");
//    	return user;


    	SqlSession session = MySqlSession.getSqlSeesion();
		

		//基于接口编程
		UserMapper obj = session.getMapper(UserMapper.class);
		

		return obj.validateUser(name,pwd);
		
    }
    
    public List<Role> selectAllRole(){
    	SqlSession session = MySqlSession.getSqlSeesion();
    	UserMapper obj = session.getMapper(UserMapper.class);
    	return obj.selectAllRole();
    }
	public List<User> selectUser(){
		SqlSession session = MySqlSession.getSqlSeesion();
		UserMapper obj = session.getMapper(UserMapper.class);
		return obj.selectUser();
	}
	
	public void save (User user) throws Exception{
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			UserMapper obj = session.getMapper(UserMapper.class);
			obj.save(user);
			if(user.getRole()!=null){
				if(user.getRole().getId()!=null){					
					logger.info("user getId"+user.getId());
					logger.info("user Role getId"+user.getRole().getId());
					obj.insertUserRole(user.getId(), user.getRole().getId());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public User getUserByID(Integer id){
//		SqlSession session = MySqlSession.getSqlSeesion();
//		UserMapper obj = session.getMapper(UserMapper.class);
//		return obj.selectUserByID(id);
		
		SqlSession session = MySqlSession.getSqlSeesion();
		UserMapper obj = session.getMapper(UserMapper.class);
		return obj.selectRoleAndUserByUserId(id);
	}
    
	
	public void update(User user){
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			UserMapper obj = session.getMapper(UserMapper.class);
			obj.update(user);
			
			//首先要查询，查询 到数据，才就1，没有就选2
			Integer id=0; //要么数字要么空。
			id= obj.selectUserRoleById(user);
			logger.info("UserDAO update id");
			logger.info(id);
//			if(id==null){
//				logger.info("id is null");				
//			}
			if(id!=null){
				obj.updateUserRole(user);//2行只能选1，否则就出错了。
			}else{				
				obj.insertUserRoleNoData(user);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 批量删除
	 */
	public void batchDelete(List<Integer> ids)throws Exception{
		try {
			SqlSession session = MySqlSession.getSqlSeesion();
			UserMapper obj = session.getMapper(UserMapper.class);
			logger.info("UserDao ids");
			logger.info(ids);
			obj.batchDeleteUserAndRole(ids);
			obj.batchDelete(ids);
			//表有关联要先删除有关联那张表
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static Logger logger = Logger.getLogger(UserDAO.class);  
}
