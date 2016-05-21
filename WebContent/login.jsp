<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
   	<link href="css/signin.css" rel="stylesheet">
   	<script src="jquery/jquery-1.9.1.min.js"></script>
   	<script src="bootstrap/js/bootstrap.min.js"></script>
	<title>Insert title here</title>
</head>

<body>
    <div class="container">
      <form class="form-signin" action="login.action" method="post">
        <h2 class="form-signin-heading">请登录</h2>
        <label for="inputUsername" class="sr-only">用户名</label>
        <input type="text" id="username" name="username" value="soft142" class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="password" name="pwd" value="abc123" class="form-control" placeholder="密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me">请记住我
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
      </form>
			
    </div> <!-- /container -->
  </body>
</html>