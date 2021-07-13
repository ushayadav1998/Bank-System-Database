<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.model.Account" %>
<%@ page import="com.model.Customer" %>
<%@ page import="com.dao.AccountDao" %>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Accounts</title>
</head>
<body>
<table border="1">
<tr>
<th>Customer ID</th>
<th>Account Number</th>
<th>Account Type</th>
<th>Balance</th>

</tr>
<%
Account t=new Account();
String cid=t.getCustomerID();
ResultSet rs=new AccountDao().getAllAccounts();
while(rs.next()){
String customerID=(String)session.getAttribute("customerID");
String accountNumber=(String)session.getAttribute("accountNumber");
if(customerID.equals(rs.getString(1))){
%>
<tr>
<td><%=rs.getString(1) %></td>
<td><%=rs.getString(2) %></td>
<td><%=rs.getString(3) %></td>
<td><%=rs.getInt(4) %></td>

<td><a href="AccountHandler?action=editform&customerID=<%=rs.getString(1) %>&accountNumber=<%=rs.getString(2) %>">Update</a></td>
<td><a href="AccountHandler?action=delete&accountNumber=<%=rs.getString(2) %>">Delete</a></td>
</tr>
<%
}
}
%>
</table>
<p><a href="AccountHandler?action=insert">Add Account</a></p>
<p><a href="LogoutServlet">Log Out</a>
</body>
</html>