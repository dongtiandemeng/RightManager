package com.right.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.right.dao.UserDAO;



public class SessionFactory {
	private static Logger logger = Logger.getLogger(SessionFactory.class);  
	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;
	
	static{
		try {
			reader = Resources.getResourceAsReader("configuration.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSessionFactory(){		

		return sqlSessionFactory;
	}
	public SessionFactory() {
		// TODO Auto-generated constructor stub
	}

}
