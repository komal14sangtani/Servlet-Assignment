package com.bookapp.model.dao;


import java.sql.*;
import java.util.*;

import com.bookapp.factory.ConnectionFactory;
import com.bookapp.model.exception.BookNotFoundException;

public class BookDaoImpl implements BookDao {

	private Connection connection;

	public BookDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public List<Book> getAll() {
		Book tempBook = null;
		List<Book> books = new ArrayList<Book>();
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book");

			while (rs.next()) {
				tempBook = new Book(rs.getInt("id"), rs.getString("name"), rs.getString("title"), rs.getDouble("price"));
				books.add(tempBook);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public void addBook(Book book) {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("insert into book(name, salary, age) values(?,?,?)");
			stmt.setString(1, book.getName());
			stmt.setString(2, book.getTitle());
			stmt.setDouble(3, book.getPrice());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBook(int id) {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("delete from book where id=?");
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(int id, Book book) {
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("update book set salary = ? where id=?");
			stmt.setString(1, book.getTitle());
			stmt.setInt(2, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Book findById(int id) {
		Book tempBook = null;
		try {
			PreparedStatement stmt = 
					connection.prepareStatement("select * from book where id=?");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				tempBook = 
						new Book(rs.getInt("id"), rs.getString("name"), rs.getString("title"), rs.getDouble("price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(tempBook==null)
			throw new BookNotFoundException("book with id "+ id +" is not found");
		return tempBook;
	}

}
