<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.right.dao.MenuDAO"%>
<%@page import="com.right.mapper.Menu"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<body>
	<script type="text/javascript">
	function submit(){
		$("#deleteMenuForm").submit();
		
		//使用Ajax将选中的checkBox提交到后台的action
		$.post("role!delete.action",$("input[@name='chk_id']:checked").serialize(),function(result){  
		    $(".content-box-content").html(result);  
		});  
	}  
	
	

</script>
<div>
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title">删除角色</h4>
		</div>
		<div class="modal-body">
			<h2>你确定要删除这些选项吗？</h2>
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			<button type="button" class="btn btn-primary" onclick="submit()">确定</button>
		</div>
	</div>
</body>
</html>