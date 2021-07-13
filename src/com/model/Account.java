package com.model;

public class Account {
	
	private String customerID;
	private String accountNumber;
	private String accountType;
	private int balance;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(String customerID, String accountNumber, String accountType,
			int balance) {
		super();
		this.customerID = customerID;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	

}
