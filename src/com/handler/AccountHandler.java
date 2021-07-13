package com.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.dao.AccountDao;
import com.model.Account;


public class AccountHandler extends HttpServlet {
	Logger logger=Logger.getLogger(AccountHandler.class);
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/account.jsp";
	private static String Edit = "/edit.jsp";
	private static String AccountRecord = "/listAccount.jsp";
	private AccountDao dao;
       
       
   
    public AccountHandler() {
        super();
        dao=new AccountDao();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String redirect="";
		
		String cID = request.getParameter("customerID");
		String aNo=request.getParameter("accountNumber");
		String action = request.getParameter("action");
		String balance=request.getParameter("balance");
		HttpSession session=request.getSession(true);
		if(!((cID)==null) && action.equalsIgnoreCase("insert"))
		{
			String id=cID;
			int bal=Integer.parseInt(balance);
			
			Account t=new Account();
			session.setAttribute("customerID", id);
			t.setCustomerID(id);
			t.setAccountNumber(request.getParameter("accountNumber"));
			t.setAccountType(request.getParameter("accountType"));
			t.setBalance(bal);
			
			dao.addAccount(t);
			redirect=AccountRecord;
			request.setAttribute("accounts", dao.getAccountByID(id,aNo));
			logger.info("Record Added Successfully");
			//System.out.println("Record Added Successfully");
		}
		else if (action.equalsIgnoreCase("delete"))
		{
			//String customerID=request.getParameter("customerID");
			String accountNumber=request.getParameter("accountNumber");
			//String cid=customerID;
			dao.removeAccount(accountNumber);
			redirect=AccountRecord;
			logger.info("Record Deleted Successfully");
			//request.setAttribute("accounts", dao.getAccountByID(customerID));
			//System.out.println("Record Deleted Successfully");
		}
		else if (action.equalsIgnoreCase("editform")){
			redirect = Edit;
		} else if (action.equalsIgnoreCase("edit"))
		{
			String customerID=request.getParameter("customerID");
			String cid=customerID;
			int bal=Integer.parseInt(balance);
			Account t1=new Account();
			t1.setCustomerID(cid);
			t1.setAccountNumber(request.getParameter("accountNumber"));
			t1.setAccountType(request.getParameter("accountType"));
			t1.setBalance(bal);
			
			dao.editAccount(t1);
			request.setAttribute("t1", t1);
			redirect = AccountRecord;
		  logger.info("Record updated Successfully");
			//System.out.println("Record updated Successfully");
		}
		else {
			redirect = INSERT;
			}

			 RequestDispatcher rd = request.getRequestDispatcher(redirect);
			rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
