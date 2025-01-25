package com.htc.ratingservice.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.htc.ratingservice.converter.RatingConverter;
import com.htc.ratingservice.dto.RatingDto;
import com.htc.ratingservice.entity.Rating;
import com.htc.ratingservice.exception.TaskException;
import com.htc.ratingservice.repository.RatingRepository;

@Service
public class RatingService {
	
	static Logger log = LogManager.getLogger(RatingService.class);

	@Autowired
	RatingRepository ratingRepository;
	
	@Autowired
	RatingConverter ratingConverter;

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public RatingDto addRating(Rating rating) throws TaskException {
		Optional<Rating> rt = ratingRepository.findById(rating.getRatingId());
		if(!rt.isPresent()) {
			ratingRepository.save(rating);
			RatingDto rtDto= ratingConverter.entityToDto(rating);
			log.info("Rating Data saved Successfully");
			return rtDto;
		}else {
			log.info("Rating Data already Exist");
			throw new TaskException("Rating Data already Exist",HttpStatus.BAD_REQUEST);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public RatingDto getRating(int ratingId) throws TaskException {
		RatingDto rtDto = new RatingDto();
		if(ratingRepository.findById(ratingId).isPresent()) {
			rtDto =ratingConverter.entityToDto(ratingRepository.findById(ratingId).get());
			log.info("Rating Data retrieved Successfully");
			return rtDto;
		}else {
			log.info("Rating Data does not  Exist");
			throw new TaskException("Rating Data does not  Exist",HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public List<RatingDto> getAllRatings() throws TaskException {
		List<Rating> rtList = (List<Rating>) ratingRepository.findAll();
		if (!CollectionUtils.isEmpty(rtList)) {
			List<Rating> rating = rtList.stream().collect(Collectors.toList());
			List<RatingDto> ratingDto =ratingConverter.listOfEntityToDto(rating);
			return ratingDto ;
		}
		throw new  TaskException("No records Found",HttpStatus.NOT_FOUND);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public boolean deleteRating(int ratingId) throws TaskException {
		if(Objects.nonNull(ratingId)) {
			ratingRepository.deleteById(ratingId);
			return true; 
		}else {
			throw new TaskException("Cannot Delete Rating",HttpStatus.BAD_REQUEST);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public RatingDto updateRating(int ratingId, String ratingLevel) throws TaskException {
		Optional<Rating> optBook =ratingRepository.findById(ratingId);
		if (optBook.isPresent()) {
			Rating rt =optBook.get();
			rt.setRatingLevel(ratingLevel);
			ratingRepository.save(rt);
			RatingDto rtDto =ratingConverter.entityToDto(rt);
			log.info("Rating Data Updated ");
			return rtDto;			
		}else {
			log.info("Rating Data  not exist");
			throw new  TaskException("No records Found",HttpStatus.NOT_FOUND);

		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public List<RatingDto> getBookRating(int bookId) {
		List<RatingDto> rtDto =ratingConverter.listOfEntityToDto(ratingRepository.findByBookId(bookId));
		return rtDto;
	}

}
