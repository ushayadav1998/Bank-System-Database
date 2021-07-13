<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Register</title>
<link href="CSS/style.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="page-container">
            
            <form action="RegisterServlet" method="POST">
			<h1>Sign Up</h1>
                <input type="text" name="customerID" class="customerID" placeholder="customerID">
                <input type="text" name="customerName" class="customerName" placeholder="customerName">
				<input type="text" name="customerAddress" class="customerAddress" placeholder="customerAddress">
				<input type="password" name="password" class="Address" placeholder="password">
                <button type="submit" value="Add" name="submit">Submit</button>
            </form>
        </div>

<!--  <form action="register" method="post">
<table>
<tr><td>Customer ID:</td><td><input type="text" name="customerID"/></td></tr>
<tr><td>Customer Name:</td><td><input type="text" name="customerName"/></td></tr>
<tr><td>Customer Address:</td><td><input type="text" name="customerAddress"/></td></tr>
<tr><td>Password:</td><td><input type="text" name="password"/></td></tr>
<tr><td><input type="submit" value="Register"></td></tr>
</table>
</form>-->

</body>
</html>