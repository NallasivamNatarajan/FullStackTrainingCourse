package com.htc.bookservice.dto;

import java.util.List;

import com.htc.bookservice.entity.Book;
import com.htc.bookservice.entity.Rating;

import lombok.Data;
@Data
public class BookRatingDto {
	private Book book;
	private List<Rating> rating;
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
		return "BookRatingDto [book=" + book + ", rating=" + rating + "]";
	}

}
