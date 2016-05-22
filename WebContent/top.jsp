<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script language="javascript">
//注销
function logout() {
	window.location.href = "check_logout.jsp";
}
</script>

	<%
		//查看有没有设置LoginAction 有没有达到这一行的效果
		//request.getSession().setAttribute("userInfo", username);
		//估计是没有
		//System.out.println("userInfo	"+request.getAttribute("userInfo"));
		//原来setAttribute变成了
		//System.out.println("top.jsp		 username	"+request.getAttribute("username"));
		//System.out.println("top.jsp	session	 username	"+session.getAttribute("username"));
	%>
<div class="col-md-12 navbar-inverse">

	<div>
		<div class="navbar-header">
			<a class="navbar-brand" href="#">权限管理系统</a>
		</div>
		<div style="float: right; margin-top: 20px; text-align: center;"">
			<!-- 错误，应该是username	<font color="white">欢迎：<%= session.getAttribute("userInfo")%> -->
			<!--错误，应该是request不是session <font color="white">欢迎：<%= session.getAttribute("username")%>  -->
			<!-- <font color="white">欢迎：<%= request.getAttribute("username")%> -->
			<!-- session <font color="white">欢迎：<%= session.getAttribute("username")%> -->
			<font color="white">欢迎：${userinfo}
			</font><a href="javascript:#"	onclick="logout();">安全退出</a>
		</div>
	</div>
</div>