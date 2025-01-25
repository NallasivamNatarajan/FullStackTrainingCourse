package com.htc.bookservice.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.htc.bookservice.dto.BookDto;
import com.htc.bookservice.entity.Book;


@Component
public class BookConverter {
	
	public Book dtoToEntity(BookDto bookDto) {
		Book book = new Book();
		BeanUtils.copyProperties(bookDto, book);
		return book;
	}
	
	public BookDto entityToDto(Book book) {
		BookDto bookDto= new BookDto();
		BeanUtils.copyProperties(book, bookDto);
		return bookDto;
	}
	
	public List<Book> listOfDtoToEntity(List<BookDto> books){
		return books.stream().map(x->dtoToEntity(x)).collect(Collectors.toList());
	}
	
	public List<BookDto> listOfEntityToDto(List<Book> books){
		return books.stream().map(x->entityToDto(x)).collect(Collectors.toList());
	}

}
