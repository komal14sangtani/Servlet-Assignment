package com.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionCotroller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// how to make a counter app with session mgt
		HttpSession httpSession = request.getSession();

		PrintWriter out = response.getWriter();

		Integer counter = (Integer) httpSession.getAttribute("counter");

		if (counter == null) {
			counter = 1;
			httpSession.setAttribute("counter", counter);
			out.print("u have visited first time");
		} else {
			counter = counter + 1;
			httpSession.setAttribute("counter", counter);
			out.print("u have already visited first time: " + counter);
		}

	}

}
