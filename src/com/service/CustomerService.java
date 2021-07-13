package com.service;

import java.sql.SQLException;

import com.model.Customer;

public interface CustomerService {
	
	  boolean loginCustomer(String customerID, String password);

	    boolean registerCustomer(Customer customer);

	    boolean checkCustomerID(String customerID) throws SQLException;

}
