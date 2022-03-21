package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterContorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//declartion of instancae variable
	private int counter=0;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.print(counter++ +"<br>");
		out.print("powered by @harman");
		
	}


}
