package com.htc.ratingservice.dto;

import lombok.Data;

@Data
public class RatingDto {
	private int ratingId;
	private int bookId;
	private String ratingLevel;
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
	@Override
	public String toString() {
		return "RatingDto [ratingId=" + ratingId + ", bookId=" + bookId + ", ratingLevel=" + ratingLevel + "]";
	}
}
