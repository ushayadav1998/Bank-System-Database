package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dbconnection.ConnectionProvider;
import com.model.Customer;

public class CustomerDao {
	
	static ConnectionProvider dbConnection = new  ConnectionProvider();
   

    public boolean login(String customerID, String password) {
      
        boolean isAuthenticated = false;
        try {

            Connection connection = dbConnection.getConnection();
            String query = "select * from customers where customerID=? and password=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerID);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            isAuthenticated = resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAuthenticated;
    }

    public boolean register(Customer customer) {
       
        try {
            Connection connection = dbConnection.getConnection();
            String query = "insert into customers values(?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, customer.getCustomerID());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerAddress());
            preparedStatement.setString(4, customer.getPassword());
          
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ResultSet getCustomers(String customerID) {
        ResultSet resultSet = null;
        try {
            Connection connection = dbConnection.getConnection();
            String query = "select * from customers where customerID = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerID);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void delete(String customerID) {
       
        try {
            Connection connection = dbConnection.getConnection();
            String query = "delete from customers where customerID=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, customerID);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
