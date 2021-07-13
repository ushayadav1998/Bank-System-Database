package com.service;

import java.sql.SQLException;

import com.dao.CustomerDao;
import com.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	 private CustomerDao customerDao = new CustomerDao();

	@Override
	public boolean loginCustomer(String customerID, String password) {
		return customerDao.login(customerID, password);
		
	}

	@Override
	public boolean registerCustomer(Customer customer) {
		return customerDao.register(customer);
	}

	@Override
	public boolean checkCustomerID(String customerID) throws SQLException {
		boolean checkCustomerID = false;
		checkCustomerID = customerDao.getCustomers(customerID).next();
        return checkCustomerID;
	}

	

}
