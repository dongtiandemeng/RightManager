<%@page import="java.util.Map"%><%@page import="java.util.List"%><%@page import="com.right.dao.MenuDAO"%><%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"><script src="jquery/jquery-1.9.1.min.js"></script><script src="bootstrap/js/bootstrap.min.js"></script><title>权限管理</title></head>	//获取父菜单的信息	<body><script type="text/javascript">	function submit(){		$("#menuForm").submit();	}</script><div>		<div class="modal-header">			<button type="button" class="close" data-dismiss="modal"				aria-label="Close">				<span aria-hidden="true">&times;</span>			</button>			<h4 class="modal-title">新增菜单</h4>		</div>		<div class="modal-body">			<form role="form" id="menuForm" action="menu!save.action" method="post">				<div class="form-group">					<label for="name">父菜单</label> 					<select name="parent_id" class="form-control" >							<option value="-1"></option>							<c:forEach items="${parentMenuList}" var="menu">								<option value="${menu.id}">${menu.name}</option>							</c:forEach>						</select>				</div>				<div class="form-group">					<label for="name">名称</label> <input type="text"						class="form-control" id="name" name="name" placeholder="请输入名称">				</div>				<div class="form-group">					<label for="ico">ico</label> <input type="text"						id="ico" name="ico" class="form-control" placeholder="请输入ICO"/>				</div>				<div class="form-group">					<label for="url">url</label> <input type="text"						id="url" name="url" class="form-control" placeholder="请输入URL"/>				</div>			</form>		</div>		<div class="modal-footer">			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>			<button type="button" class="btn btn-primary" onclick="submit()">确定</button>		</div>	</div></body></html>