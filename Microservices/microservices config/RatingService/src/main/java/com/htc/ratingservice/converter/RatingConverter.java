package com.htc.ratingservice.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.htc.ratingservice.dto.RatingDto;
import com.htc.ratingservice.entity.Rating;

@Component
public class RatingConverter {
	
	public Rating dtoToEntity(RatingDto ratingDto) {
		Rating rating = new Rating();
		BeanUtils.copyProperties(ratingDto, rating);
		return rating;
	}
	
	public RatingDto entityToDto(Rating rating) {
		RatingDto ratingDto= new RatingDto();
		BeanUtils.copyProperties(rating, ratingDto);
		return ratingDto;
	}
	
	public List<Rating> listOfDtoToEntity(List<RatingDto> ratings){
		return ratings.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public List<RatingDto> listOfEntityToDto(List<Rating> ratings){
		return ratings.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}

}

