<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>System Login Page</title>
</head>
<body>
	<form action="login_action" method = "post">
		<div class="Login_form_div">
			UserName:<input type="text" name = "userName" /><br>
			Password:<input type="password" name = "password" /><br>
		</div>
		<div class = "login_form_op_div">
			<input type = "submit" value = "submit"/>
			<input type = "reset" value = "reset"/>
		</div>

	</form>
</body>
</html>