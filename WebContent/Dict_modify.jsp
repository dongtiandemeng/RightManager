<%@page import="java.util.Map"%><%@page import="java.util.List"%><%@page import="com.right.dao.MenuDAO"%><%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"><script src="jquery/jquery-1.9.1.min.js"></script><script src="bootstrap/js/bootstrap.min.js"></script><title>权限管理</title></head><body><script type="text/javascript">	function submit(){		$("#menuForm").submit();	}</script><div>		<div class="modal-header">			<button type="button" class="close" data-dismiss="modal"				aria-label="Close">				<span aria-hidden="true">&times;</span>			</button>			<h4 class="modal-title">修改字典</h4>		</div>		<div class="modal-body">			<form role="form" id="menuForm" action="dict!update.action" method="post">				<div class="form-group">					<label for="name">父菜单</label>					 				<div class="form-group">					<label for="name">字典类型</label> 					<select name="dict.dictionaryType_code" class="form-control" >							<c:if test="${ empty dict.dictionaryType}">								<option value="-1"></option>								</c:if>							<option value="${dict.dictionaryType.code}">${dict.dictionaryType.name}</option>							<c:forEach items="${dictTypeList}" var="dictType">								<c:if test="${dict.dictionaryType.name !=dictType.name }">									<option value="${dictType.code}">${dictType.name}</option>								</c:if>								</c:forEach>					</select>				</div>												</div>				<input type="hidden" name="dict.id" value="${dict.id}"/>				<div class="form-group">					<label for="ico">名称</label> <input type="text" value="${dict.name }"						id="name" name="dict.name" class="form-control" placeholder="请输入名称"/>				</div>				<div class="form-group">					<label for="code">code</label> <input type="text" value="${dict.code }"						id="dict" name="dict.code" class="form-control" placeholder="请输入code"/>				</div>			</form>		</div>		<div class="modal-footer">			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>			<button type="button" class="btn btn-primary" onclick="submit()">确定</button>		</div>	</div></body></html>