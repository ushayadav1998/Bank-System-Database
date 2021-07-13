package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.controller.CustomerController;
import com.controller.CustomerControllerImpl;


public class LoginServlet extends HttpServlet {
	private String MSG_ERROR = "Invalid username or password";
	private static final long serialVersionUID = 1L;
	
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
	        String customerID = request.getParameter("customerID");
	        String password = request.getParameter("password");
	        CustomerController customerController = new  CustomerControllerImpl();
	        if (customerController.loginCustomer(customerID, password)) {
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher("dashboard.jsp");
	            HttpSession session = request.getSession(true);
	            session.setAttribute("customerID", customerID);
	            requestDispatcher.forward(request, response);
	        } else {
	            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
	            ServletContext servletContext = getServletContext();
	            servletContext.removeAttribute("logoutMessage");
	            servletContext.removeAttribute("success");
	            servletContext.setAttribute("ErrorMessage", MSG_ERROR);
	            requestDispatcher.forward(request, response);
	        }
	}

}
