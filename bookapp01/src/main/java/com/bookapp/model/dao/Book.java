package com.bookapp.model.dao;
//DTO: data transfer object
public class Book {
	private int id ;
	private String name;
	private String title;
	private double price;


	public Book(String name,String title, double price) {
		this.name = name;
		this.title = title;
		this.price = price;
	}

	
	
	public Book(int id, String name,String title ,double price) {
		this.id = id;
		this.name = name;
		this.title = title;
		this.price = price;
	}

	public Book() {}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String  getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", title=" + title + ", price=" + price+ "]";
	}
	
	
}
