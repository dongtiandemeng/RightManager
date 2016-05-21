<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.right.dao.MenuDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<%
	String str = request.getParameter("str");
	System.out.println("str"+str);
	String strs[]=str.split("-");
	
	List<Map<String,Object>> parentMenuList = new ArrayList<Map<String,Object>>();
	for(String subString:strs){
		System.out.println("subString"+subString);	
		//原来是没有
		MenuDAO ma = new MenuDAO();
		Map<String,Object> menu = ma.getMenuByID(subString);
		
		System.out.println(menu.get("id"));
		System.out.println(menu.get("name"));
		System.out.println(menu.get("url"));
		System.out.println(menu.get("ico"));
		System.out.println(menu.get("parent_id"));
		
		//
		parentMenuList.add(menu);
	}
	//id获取数据，加载到html页面，再决定是否要删除
	
	
	
	//获取父菜单的信息
	//String menu_id = request.getParameter("id");
	//List<Map<String,Object>> parentMenuList = null;
	//MenuAction ma = new MenuAction();
	//parentMenuList = ma.getParentMenuList();
	//Map<String,Object> menu = ma.getMenuByID(menu_id);
%>
<body>
	<script type="text/javascript">
	function submit(){
		$("#deleteMenuForm").submit();
	}
</script>
<div>
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title">删除菜单</h4>
		</div>
		<div class="modal-body">
			<form role="form" id="deleteMenuForm" action="MenuDelServlet" method="post">
				<!--显示删除的数据  -->
								
				<table class="table table-striped table-bordered">
					<caption>菜单列表</caption>
					<thead>
						<tr>
							<th>选择</th>
							<th>id</th>
							<th>名称</th>
							<th>url</th>
							<th>ico</th>
						</tr>
					</thead>
					<tbody>
						
						<%							
							//MenuAction ma = new MenuAction();			
							//List<Map<String, Object>> menuList = 
									
								//	ma.getMenuList();	
							
							for (Map<String, Object> menu : parentMenuList) {
						%>
						<tr>
							<td><input type="checkbox" name="chk_id" value="<%=menu.get("id")%>" checked="checked"/></td>
							<!-- 这里不对啊，你这里是前端的代码，你却要将前端的代码交给后台处理。 -->
							<td><%=menu.get("id")%></td>
							<td><%=menu.get("name")%></td>
							<td><%=menu.get("url")%></td>
							<td><%=menu.get("ico")%></td>
						</tr>
						<%							
							}
						%>
					</tbody>
				</table>
				
				
				<!--显示删除的数据  end-->
			</form>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			<button type="button" class="btn btn-primary" onclick="submit()">确定</button>
		</div>
	</div>
</body>
</html>