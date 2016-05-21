package rm.servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.right.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		
		// TODO Auto-generated method stub
		UserDAO dao = new UserDAO();
		boolean retval = dao.validateUser(name, pwd);
		
		if(retval==true){
		
//		if(retval.equals("true")){
			
			//顺序错误了，如果先添加后再判断，肯定重复登录了
			//应该先判断，再添加
//			System.out.println("LoginServlet setAttribute before");
//			request.getSession().setAttribute("userInfo", name);
//			System.out.println("LoginServlet setAttribute after");
			
			//跳转到list.jsp
			
			//死循环，第一次进入else,第2次进入if
			
			//应该设置一个标志，就是没有一个相同的时候，再进行if和else判断
			
			Set all = (Set)super.getServletContext().getAttribute("online");
			Iterator iter = all.iterator();
			boolean flag=false;//如果true，就说明有重复
			while(iter.hasNext()){
				String listName=(String)iter.next();
				if(name.equals(listName)){
					flag = true;
				}
			}
			if(flag){				
				System.out.println("请不要重复登录");
				RequestDispatcher rd = request.getRequestDispatcher("repeat.html");
				rd.forward(request, response);
				flag = false;
			}else{
				//顺序错了，这里遍历，根本没有值，还没设置值就遍历
				
				System.out.println("LoginServlet setAttribute before");
				request.getSession().setAttribute("userInfo", name);
				System.out.println("LoginServlet setAttribute after");
				
				System.out.println("用户第一次登录");
				//response.sendRedirect("menu.jsp");
				RequestDispatcher rdMenu = request.getRequestDispatcher("menu.jsp");
				rdMenu.forward(request, response);
			}				
			
			//重定向，客户端跳转
			//response.sendRedirect("menu.jsp");
			//转向，服务器端跳转
			//RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
			//rd.forward(request, response);
		}else{
			response.sendRedirect("failure.jsp");
		}
	}

}
