package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;





import com.dbconnection.ConnectionProvider;
import com.model.Account;


public class AccountDao {
private Connection conn;
//Logger log = new MyLogger().getLogger(getClass());

 public AccountDao()
{
conn = ConnectionProvider.getConnection();
}
public void addAccount(Account account)
{ 
	//log.info("add ticket is called");
try{
String sql="INSERT INTO accounts(customerID,accountNumber,accountType,balance) "
+ "VALUES(?,?,?,?)";
PreparedStatement ps=conn.prepareStatement(sql);
ps.setString(1,account.getCustomerID());
ps.setString(2, account.getAccountNumber());
ps.setString(3, account.getAccountType());
ps.setInt(4, account.getBalance());

ps.executeUpdate();
}catch(SQLException e){
e.printStackTrace();
}
}
public void removeAccount(String accountNumber)
{
try{
String sql="DELETE FROM accounts WHERE accountNumber=?";
PreparedStatement ps=conn.prepareStatement(sql);
ps.setString(1, accountNumber);
//ps.setString(1, customerID);
//ps.setString(2, accountNumber);
ps.executeUpdate();
}catch(SQLException e)
{
e.printStackTrace();
}
}
public void editAccount(Account account)
{
try{
String sql="UPDATE accounts SET accountType=?,balance=?"
+ " WHERE accountNumber=? AND customerID=?";
PreparedStatement ps=conn.prepareStatement(sql);
ps.setString(3,account.getAccountNumber());
ps.setString(1, account.getAccountType());
ps.setInt(2, account.getBalance());
ps.setString(4,account.getCustomerID());

ps.executeUpdate();
}catch(SQLException e)
{
e.printStackTrace();
}
}
public ResultSet getAllAccounts(){
ResultSet rst=null;
try
{
String sql="SELECT * FROM accounts ";
PreparedStatement ps=conn.prepareStatement(sql);
rst=ps.executeQuery();
}catch(SQLException e){
e.printStackTrace();
}
return rst;
}
public Account getAccountByID(String customerID,String accountNumber)
{
Account account=new Account();
try{
String sql="SELECT * FROM accounts WHERE customerID=? and accountNumber=?";
PreparedStatement ps = conn.
prepareStatement(sql);
ps.setString(1, customerID);
ps.setString(2, accountNumber);
ResultSet rs = ps.executeQuery();

 if (rs.next())
{
	 account.setCustomerID(rs.getString("customerID"));
	 account.setAccountNumber(rs.getString("accountNumber"));
	 account.setAccountType(rs.getString("accountType"));
	 account.setBalance(rs.getInt("balance"));

}
}catch (SQLException e) {
e.printStackTrace();
}
return account;
}
}