package com.htc.bookservice.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.htc.bookservice.entity.Rating;

@Component
@FeignClient(name="rating-service",url="http://localhost:8092/")
public interface BookRatingService {
	@RequestMapping(method=RequestMethod.GET,value="book/{id}/rating")
	ResponseEntity<List<Rating>> bookRating(@PathVariable("id") int bookId);

}
