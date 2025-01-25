package com.htc.ratingservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="rating")
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	
	@Id
	@Column(name="rating_id")
	private int ratingId;
	@Column(name="book_id")
	private int bookId;
	public int getRatingId() {
		return ratingId;
	}
	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getRatingLevel() {
		return ratingLevel;
	}
	public void setRatingLevel(String ratingLevel) {
		this.ratingLevel = ratingLevel;
	}
	@Column(name="rating_level")
	private String ratingLevel;
	
}
