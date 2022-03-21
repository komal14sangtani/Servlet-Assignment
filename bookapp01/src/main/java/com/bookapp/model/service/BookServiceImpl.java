package com.bookapp.model.service;

import java.util.List;

import com.bookapp.model.dao.Book;
import com.bookapp.model.dao.BookDao;
import com.bookapp.model.dao.BookDaoImpl;
//service layer is just like brain of our application
//Cross cutting concern* tx , security, caching
public class BookServiceImpl implements BookService{

	private BookDao bookDao;
	
	
	public BookServiceImpl() {
		bookDao=new BookDaoImpl();
	}

	@Override
	public List<Book> getAll() {
		return bookDao.getAll();
	}

	@Override
	public void addBook(Book book) {
		bookDao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		bookDao.deleteBook(id);
	}

	@Override
	public void updateBook(int id, Book book) {
		bookDao.updateBook(id, book);
	}

	@Override
	public Book findById(int id) {
		return bookDao.findById(id);
	}

}
