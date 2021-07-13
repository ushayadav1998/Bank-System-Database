package com.handler;

import java.io.InputStream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;


public class MyLogger implements ServletContextListener {

    
    public MyLogger() {
        // TODO Auto-generated constructor stub
    }

	
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent arg0) {
    	 InputStream in=getClass().getResourceAsStream("/com/handler/log4j.properties");
         
         if(in!=null){
         	PropertyConfigurator.configure(in);
         	System.out.println("Logger is configured with custom setting");
         }else{
         	BasicConfigurator.configure();
         	System.out.println("Logger is Configured with Default setting");
         }
    }
	
}
