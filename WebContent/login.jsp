<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form action="LoginServlet" method="post">
<table>
<tr><td>Customer ID:</td><td><input type="text" name="customerID"/>(This field cannot be empty)</td></tr>
<tr><td>Password:</td><td><input type="text" name="password"/>(This field cannot be empty)</td></tr>
<tr><td><input type="submit" value="Login"/></td></tr>
<p>First time user ?<a href="register.jsp">Register here</a></p>
<p>Otherwise Login Below</p>
</table>
</form>

</body>
</html>