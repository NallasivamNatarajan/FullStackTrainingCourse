package com.htc.bookservice.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.htc.bookservice.dto.BookDto;
import com.htc.bookservice.dto.BookRatingDto;
import com.htc.bookservice.entity.Book;
import com.htc.bookservice.exception.TaskException;
import com.htc.bookservice.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@PostMapping(value="/book", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> addBook( @RequestBody Book book) throws TaskException {
		BookDto bk = bookService.addBook(book);
		HttpHeaders headers = getHeaders("Post");
		if (bk != null) {
			return new ResponseEntity<>(bk,headers,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/book/{bookId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> getBook(@PathVariable("bookId") int bookId) throws TaskException{
		BookDto book = bookService.getBook(bookId);
		HttpHeaders headers = getHeaders("GET");
		if (book != null) {
			return new ResponseEntity<>(book,headers,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/book", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookDto>> getAllBooks() throws TaskException{
		List<BookDto> bookList = bookService.getAllBooks();
		HttpHeaders headers = getHeaders("GET");
		if (bookList != null) {
			return new ResponseEntity<>(bookList,headers,HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value="/book/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable("bookId")int bookId) throws TaskException{
		HttpHeaders headers = getHeaders("DELETE");
		if (bookService.deleteBook(bookId)) {
			return new ResponseEntity<>(headers,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	@PutMapping(value="/book/{bookId}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookDto> updateBook(@PathVariable("bookId") int bookId,@RequestParam("bookName")String bookName) throws TaskException{
		BookDto book = bookService.updateBook(bookId,bookName);
		HttpHeaders headers = getHeaders("PUT");
		if (book != null) {
			return new ResponseEntity<>(book,headers,HttpStatus.CREATED);
		}else {
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value="/book/{id}/rating",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BookRatingDto> bookRating(@PathVariable("id") int id) throws TaskException{
		BookRatingDto ratingList = bookService.getBookRating(id);
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
