package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.CustomerController;
import com.controller.CustomerControllerImpl;
import com.model.Customer;


public class RegisterServlet extends HttpServlet {
	 private String MSG_REGISTER = "Registered successfully. Login to continue";
	private static final long serialVersionUID = 1L;
    
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
        String customerID = request.getParameter("customerID");
        String customerName = request.getParameter("customerName");
        String customerAddress = request.getParameter("customerAddress");
        String password = request.getParameter("password");
       
        CustomerController customerController = new  CustomerControllerImpl();
        Customer customer = new Customer(customerID, customerName, customerAddress,  password);
        try {
            if (customerController.checkCustomerID(customerID)) {
                ServletContext servletContext = getServletContext();
                String customerIDFoundMsg = customerID + " already taken";
                servletContext.setAttribute("foundCustomerID", customerIDFoundMsg);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
                requestDispatcher.forward(request, response);
            } else if (customerController.registerCustomer(customer)) {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
                ServletContext servletContext = getServletContext();
                servletContext.removeAttribute("logoutMessage");
                servletContext.setAttribute("success", MSG_REGISTER);
                requestDispatcher.forward(request, response);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
