package com.htc.bookservice.entity;

import java.util.List;

public class BookRating {
	
	private Book book;
	private List<Rating> rating;
	
	public BookRating() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookRating(Book book, List<Rating> rating) {
		super();
		this.book = book;
		this.rating = rating;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public List<Rating> getRating() {
		return rating;
	}
	public void setRating(List<Rating> rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "BookRating [book=" + book + ", rating=" + rating + "]";
	}
	
	
}
