package com.right.dao;
import java.sql.*;
/**
 * 处理用户信息
 * 
 * @author Administrator
 * 
 */
public class UserDAO {
	public static final String url = "jdbc:mysql://172.16.123.161/rightdb";  
    public static final String name = "com.mysql.jdbc.Driver";  
    public static final String user = "root";  
    public static final String password = "123456";  
  
    public Connection conn = null;  
	/**
	 * 处理用户登录信息
	 * 
	 * @return 正确返回：true 错误返回：false
	 */
	public boolean validateUser(String name, String pwd) {
		try {
			// 连接数据库
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,password);
			// 提交验证查询语句
			String sql = "select * from t_base_user where loginname=? and password=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, name);
			pst.setString(2, pwd);
			ResultSet rs = pst.executeQuery();
			// 根据返回结果返回验证结果
			if(rs.next())
				return true;
			else
				return false;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}
}
