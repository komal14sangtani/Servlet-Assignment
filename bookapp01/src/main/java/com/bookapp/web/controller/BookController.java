package com.bookapp.web.controller;

import java.util.*;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.model.dao.Book;
import com.bookapp.model.service.BookService;
import com.bookapp.model.service.BookServiceImpl;

@WebServlet("/bookcontroller")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BookService bookService = new BookServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		if (action.equals("showall")) {
			List<Book> books = bookService.getAll();

			request.setAttribute("books", books);

			RequestDispatcher rd = request.getRequestDispatcher("show.jsp");
			rd.forward(request, response);

		} else if (action.equals("add")) {
			// he want to add new book
			RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
			rd.forward(request, response);
		} else if (action.equals("del")) {
			int id = Integer.parseInt(request.getParameter("id"));
			bookService.deleteBook(id);
			response.sendRedirect("empcontroller?action=showall");

		} else if (action.equals("update")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Book book = bookService.findById(id);
			request.setAttribute("book", book);
			RequestDispatcher rd = request.getRequestDispatcher("update.jsp");
			rd.forward(request, response);
		}
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// now what i need to do? i need to take data from the req

		int id = Integer.parseInt(request.getParameter("id").trim());
		String name = request.getParameter("name");
		String title = (request.getParameter("title"));
		double price = Double.parseDouble(request.getParameter("price"));

		Book book = new Book(name, title, price);
		if (id == 0) {
			bookService.addBook(book);
		} else {
			bookService.updateBook(id,book);
		}

		// What is the diff bw redirect and requestdispaching*
		// after Post redirect to Get
		// Pls study about a design patten ie called PRG design pattern, double form
		// submission problem
		response.sendRedirect("bookcontroller?action=showall");
	}

}
