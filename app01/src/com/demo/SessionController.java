package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession httpSession=request.getSession();
		
		out.print("session id"+httpSession.getId()+"<br>");
		out.print("session creation time"+ httpSession.getCreationTime()+"<br>");
		out.print("is session is new"+ httpSession.isNew()+"<br>");
		out.print("session getLastAccessedTime"+httpSession.getLastAccessedTime()+"<br>");
		out.print("session getMaxInactiveInterval"+httpSession.getMaxInactiveInterval()+"<br>");
		
		
			
	}

	

}
