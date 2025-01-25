package com.htc.ratingservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.ratingservice.entity.Rating;
@Repository
public interface RatingRepository extends CrudRepository<Rating, Integer>{

	public List<Rating> findByBookId(int bookId);
}
