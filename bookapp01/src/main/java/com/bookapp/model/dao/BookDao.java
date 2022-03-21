package com.bookapp.model.dao;
import java.util.*;
//Dao :data access object ie it is a abstraction over crud operation

public interface BookDao {
	public List<Book> getAll();
	public void addBook(Book book);
	public void deleteBook(int id);
	public void updateBook(int id, Book book);
	public Book findById(int id);
}
