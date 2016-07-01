package com.right.common;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import com.right.action.LoginAction;

public class MySqlSession {
	private static Logger logger = Logger.getLogger(MySqlSession.class);  
	private static ThreadLocal<SqlSession> t1 = new ThreadLocal<SqlSession>();
	
	public static SqlSession getSqlSeesion(){

		try {
			SqlSession sqlSession = t1.get();
//			logger.error("SqlSession sqlSession"+sqlSession);
			if(sqlSession == null){
				sqlSession = 
						SessionFactory.getSessionFactory().openSession();
//				logger.error("thred setSqlSeesion openSession"+sqlSession);
				t1.set(sqlSession);
//				logger.error("set"+sqlSession);
			}
//			logger.error("thred getSqlSeesion"+sqlSession);
			return sqlSession;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void commit(){
		if(t1.get()!=null){
			t1.get().commit();
			t1.get().close();
			t1.set(null);
		}
	}
	
	public static void rollback(){
		if(t1.get()!=null){
			t1.get().rollback();
			t1.get().close();
			t1.set(null);
		}
	}
	public MySqlSession() {
		// TODO Auto-generated constructor stub
	}

}
