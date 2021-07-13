<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Account</title>
</head>
<body>
<%
String customerID=request.getParameter("customerID");
session.setAttribute("customerID", customerID);
%>
<form method="POST" action='AccountHandler' name="frmAddCustomer">
<input type="hidden" name="action" value="insert" />
<p><b>Add Account here</b></p>
<table>
<tr>
<td>Customer ID</td>
<td><input type="text" name="customerID" /></td>
</tr>
<tr>
<td>Account Number</td>
<td><input type="text" name="accountNumber"/></td>
</tr>
<tr>
<td>Account Type </td>
<td><input type="text" name="accountType" /></td>
</tr>
<tr>
<td>Balance</td>
<td><input type="text" name="balance" /></td>
</tr>

<tr>

<td><input type="submit" value="Submit" /></td>
</tr>
</table>
</form>
<p><a href="AccountHandler?action=listAccount">View-All-Accounts</a></p>
</body>
</html>