package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String name;
    //1. must have default ctr
    public HelloController() {
       System.out.println("ctr of servlet");
    }
  //2
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		name=config.getInitParameter("name");
		
		System.out.println("init is called");
	}
	////3 ==> N
	//doGet vs doPost 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("hello to servlet api : "+name+" "+ LocalDateTime.now());
		System.out.println("doget method of servet");
	}
	

	//4
  	@Override
	public void destroy() {
  		System.out.println("destory is called");
	}
}





