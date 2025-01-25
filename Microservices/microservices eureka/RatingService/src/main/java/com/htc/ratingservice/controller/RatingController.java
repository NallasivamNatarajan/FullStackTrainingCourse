package com.htc.ratingservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htc.ratingservice.dto.RatingDto;
import com.htc.ratingservice.entity.Rating;
import com.htc.ratingservice.exception.TaskException;
import com.htc.ratingservice.service.RatingService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	
	@Autowired
	RatingService ratingService;
	
	@PostMapping(value="/rating", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RatingDto> addRating( @RequestBody Rating rating) throws TaskException {
		RatingDto rt = ratingService.addRating(rating);
		HttpHeaders headers = getHeaders("Post");
		if (rt != null) {
			return new ResponseEntity<>(rt,headers,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/rating/{ratingId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RatingDto> getRating(@PathVariable("ratingId") int ratingId) throws TaskException{
		RatingDto rating = ratingService.getRating(ratingId);
		HttpHeaders headers = getHeaders("GET");
		if (rating != null) {
			return new ResponseEntity<>(rating,headers,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/rating", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RatingDto>> getAllRatings() throws TaskException{
		List<RatingDto> ratingList = ratingService.getAllRatings();
		HttpHeaders headers = getHeaders("GET");
		if (ratingList != null) {
			return new ResponseEntity<>(ratingList,headers,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value="/rating/{ratingId}")
	public ResponseEntity<String> deleteRating(@PathVariable("ratingId")int ratingId) throws TaskException{
		HttpHeaders headers = getHeaders("DELETE");
		if (ratingService.deleteRating(ratingId)) {
			return new ResponseEntity<>(headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@PutMapping(value="/rating/{ratingId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RatingDto> updateRating(@PathVariable("ratingId") int ratingId,@RequestParam("ratingLevel")String ratingLevel) throws TaskException{
		RatingDto rating = ratingService.updateRating(ratingId,ratingLevel);
		HttpHeaders headers = getHeaders("PUT");
		if (rating != null) {
			return new ResponseEntity<>(rating,headers,HttpStatus.CREATED);
		}else {
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/book/{id}/rating",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RatingDto>> bookRating(@PathVariable("id") int bookId){
		List<RatingDto> ratingList = ratingService.getBookRating(bookId);
		HttpHeaders headers = getHeaders("GET");
		if (ratingList != null) {
			return new ResponseEntity<>(ratingList,headers,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	private HttpHeaders getHeaders(String method) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json");
		headers.add("Access-Control-Allow-Orgin", "*");
		headers.add("Access-Control-Allow-Headers", "Origin, X-Requested-With,Content-Type,Accept");
		headers.add("Access-Control-Allow-Methods", method);
		return headers;
	}
	
	

}
