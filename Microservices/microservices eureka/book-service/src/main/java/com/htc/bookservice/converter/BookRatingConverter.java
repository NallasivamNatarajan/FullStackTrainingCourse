package com.htc.bookservice.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.htc.bookservice.dto.BookRatingDto;
import com.htc.bookservice.entity.BookRating;

@Component
public class BookRatingConverter {
	
	public BookRating dtoToEntity(BookRatingDto bookRatingDto) {
		BookRating bookRating = new BookRating();
		BeanUtils.copyProperties(bookRatingDto, bookRating);
		return bookRating;
	}
	
	public BookRatingDto entityToDto(BookRating bookRating) {
		BookRatingDto bookRatingDto= new BookRatingDto();
		BeanUtils.copyProperties(bookRating, bookRatingDto);
		return bookRatingDto;
	}
	
	public List<BookRating> listOfDtoToEntity(List<BookRatingDto> bookRatingDto){
		return bookRatingDto.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public List<BookRatingDto> listOfEntityToDto(List<BookRating> bookRating){
		return bookRating.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}

}
