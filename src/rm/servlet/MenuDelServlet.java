package rm.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenuDelServlet
 */
@WebServlet("/MenuDelServlet")
public class MenuDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String url = "jdbc:mysql://172.16.123.161/rightdb";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "123456";

	public Connection conn = null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取id然后删除
		
		request.setCharacterEncoding("UTF-8");
		System.out.println("MenuDelServlet");
		PreparedStatement st =null;
		String[] chk_id = request.getParameterValues("chk_id");
		

			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
				for(String id:chk_id){
					//System.out.println("id"+id);
				
					String sql = "delete from t_base_menu where id="+id;
					st = conn.prepareStatement(sql);
					
					int rs = st.executeUpdate();
					
					
				}
				conn.close();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		
		response.sendRedirect("menu.jsp");
		
		
		
//		try {
//			List<Map<String, Object>> menuList = new ArrayList<Map<String, Object>>();
//			// 连接数据库
//			//Class.forName("com.mysql.jdbc.Driver");
//			//conn = DriverManager.getConnection(url, user, password);
//			//名字相同，值却不同。
//			String[] chk_id = request.getParameterValues("chk_id");
//			System.out.println("MenuDelServlet");
//			//PreparedStatement st =null;
//			System.out.println(chk_id);
//			for(String id:chk_id){
//				//System.out.println("id"+id);
//			
//				String sql = "delete from t_base_menu where id="+id;
//				//st = con.prepareStatement(sql);
//				//System.out.println("delete con.prepareStatement ");
//				//ResultSet rs = st.executeQuery();
//				//System.out.println("ResultSet");
//				
//			}
//			response.sendRedirect("menu.jsp");
//			
//			List delArray =new ArrayList(); 
//			//和javascript不同，不能得到checked的属性，那么就只能在哪里用隐含字段传递复选框的状态过来。
//			//那个复选框的状态是动态变化的，所以用隐含字段根本办不到，只能用javascript才能确定，也就是说，这么不能用
//			//java代码，只能用javascript去确定复选框的状态。
//			//然后再将javascript传递给java代码或者jsp
//			
//			
////			for (int i=0; i < chk_id.length; i++) {
////				if (chk_id[i].checked == true)
////					break;
////			}
////			String deleteMenuForm = request.getP.getParameter("chk_id");
//			
//			// 提交查询语句
////			String sql = "select * from t_base_menu ";
////			PreparedStatement st = con.prepareStatement(sql);
////			ResultSet rs = st.executeQuery();
////			while (rs.next()) {
////				Map<String, Object> menu = new HashMap<String, Object>();
////				menu.put("id", rs.getInt("ID"));
////				menu.put("name", rs.getString("NAME"));
////				menu.put("url", rs.getString("URL"));
////				menu.put("ico", rs.getString("ICO"));
////				menuList.add(menu);
////			}
//			
//			
//			//conn.close();
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
