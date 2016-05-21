package rm.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.right.dao.MenuDAO;

/**
 * Servlet implementation class MenuSaveServlet
 */
@WebServlet("/MenuSaveServlet")
public class MenuSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenuSaveServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String ico = request.getParameter("ico");
		String url = request.getParameter("url");
		String parent_id = request.getParameter("parent_id");
		
		Map<String, Object> menu = new HashMap<String, Object>();
		menu.put("id", id);
		menu.put("name", name);
		menu.put("ico",ico);
		menu.put("url", url);
		menu.put("parent_id", parent_id);
		MenuDAO ma = new MenuDAO();
		ma.save(menu);
		
		response.sendRedirect("menu.jsp");
	}

}
