package com.controller;

import java.sql.SQLException;

import com.model.Customer;
import com.service.CustomerService;
import com.service.CustomerServiceImpl;

public class CustomerControllerImpl implements CustomerController {
	 CustomerService customerService = new CustomerServiceImpl();


	@Override
	public boolean loginCustomer(String customerID, String password) {
		return customerService.loginCustomer(customerID, password);
	}

	@Override
	public boolean registerCustomer(Customer customer) {
		 return customerService.registerCustomer(customer);
	}

	@Override
	public boolean checkCustomerID(String customerID) throws SQLException {
		 return customerService.checkCustomerID(customerID);
	}

}
