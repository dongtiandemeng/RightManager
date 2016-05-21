<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>


<%
	Set all = (Set) this.getServletContext().getAttribute("online");
	Iterator iter = all.iterator();
	while(iter.hasNext()){
%>
	<%= iter.next() %>、
<%
	}

%>
	<!-- 退出要提交表单的，提交表单之后再设置session退出？ -->
		
	<a href="check_logout.jsp" >安全退出
	</a>
	<!-- 
	退出就从列表中删除数据
	这里需要点击按钮，再让session失效，我不知道在javaScript中是不是可以调用JSp语句，好像不可以，那怎么点击按钮之后再让session失效呢？
	目的：点击按钮就让session失效，或者关掉浏览器就要让session失效
	 -->
</body>
</html>