<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.model.Account"%>
<%@ page import="com.dao.AccountDao"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Account</title>
</head>
<body>
<body>
<%
Account account = new Account();
%>
<%
AccountDao dao = new AccountDao();
%>
<form method="POST" action='AccountHandler' name="frmEditAccount">
<input type="hidden" name="action" value="edit" />
<%
String cid = request.getParameter("customerID");
String accountNumber=request.getParameter("accountNumber");
if (!((cid) == null)) {
String id=cid;
String aNo=accountNumber;
account = dao.getAccountByID(id,aNo);
System.out.println(id);
%>
<table>
<tr>
<td>Customer ID</td>
<td><input type="text" name="customerID" readonly="readonly"
value="<%=account.getCustomerID()%>" ,disabled></td>
</tr>
<tr>
<td>Account Number</td>
<td><input type="text" name="accountNumber" readonly="readonly"
value="<%=account.getAccountNumber() %>" ,disabled></td>
</tr>
<tr>
<td>Account Type</td>
<td><input type="text" name="accountType" value="<%=account.getAccountType() %>"/></td>
</tr>
<tr>
<td>Balance</td>
<td><input type="text" name="balance" value="<%=account.getBalance() %>"/></td>
</tr>

<tr>
<td></td>
<td><input type="submit" value="Update" /></td>
</tr>
</table>
<%
} else
out.println("ID Not Found");
%>
</form>
</body>
</html>