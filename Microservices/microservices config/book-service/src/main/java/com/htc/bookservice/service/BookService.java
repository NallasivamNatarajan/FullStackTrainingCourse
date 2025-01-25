package com.htc.bookservice.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import com.htc.bookservice.converter.BookConverter;
import com.htc.bookservice.converter.BookRatingConverter;
import com.htc.bookservice.dto.BookDto;
import com.htc.bookservice.dto.BookRatingDto;
import com.htc.bookservice.entity.Book;
import com.htc.bookservice.entity.BookRating;
import com.htc.bookservice.entity.Rating;
import com.htc.bookservice.exception.TaskException;
import com.htc.bookservice.repository.BookRepository;

@Service
public class BookService {
	
	static Logger log = LogManager.getLogger(BookService.class);

	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	BookConverter bookConverter;
	
	@Autowired
	BookRatingConverter bookRatingConverter;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
    BookRatingService bookRatingService;
	
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public BookDto addBook(Book book) throws TaskException {
		Optional<Book> bk = bookRepository.findById(book.getBookId());
		if(!bk.isPresent()) {
			bookRepository.save(book);
			BookDto bookDto=bookConverter.entityToDto(book);
			log.info("Book Data saved Successfully");
			return bookDto;
		}else {
			log.info("Book Data already Exist");
			throw new TaskException("Book Data already Exist",HttpStatus.BAD_REQUEST);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public BookDto getBook(int bookId) throws TaskException {
		BookDto bookDto = new BookDto();
		if (bookRepository.findById(bookId).isPresent()) {
			bookDto=bookConverter.entityToDto(bookRepository.findById(bookId).get());
			log.info("Book Retrieved Successfully");
			return bookDto;
		}else {
			log.info("Book Data does not exist");
			throw new TaskException("Book Data does not exist",HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public List<BookDto> getAllBooks() throws TaskException {
		List<Book> bookList = (List<Book>) bookRepository.findAll();
		if (!CollectionUtils.isEmpty(bookList)) {
			List<Book> books = bookList.stream().collect(Collectors.toList());
			List<BookDto> bookDto =bookConverter.listOfEntityToDto(books);
			return bookDto ;
		}
		throw new  TaskException("No records Found",HttpStatus.NOT_FOUND);
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public boolean deleteBook(int bookId) throws TaskException {
		if (Objects.nonNull(bookId)) {
			bookRepository.deleteById(bookId);
			log.info("Book Data Deleted ");
			return true;			
		}else {
			log.info("Cannot Delete Book");
			throw new  TaskException("Cannot Delete Book",HttpStatus.BAD_REQUEST);

		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public BookDto updateBook(int bookId, String bookName) throws TaskException {
		Optional<Book> optBook =bookRepository.findById(bookId);
		if (optBook.isPresent()) {
			Book bk =optBook.get();
			bk.setBookName(bookName);
			bookRepository.save(bk);
			BookDto bookDto = bookConverter.entityToDto(bk);
			log.info("Book Data Updated ");
			return bookDto;			
		}else {
			log.info("Book Data  not exist");
			throw new  TaskException("No records Found",HttpStatus.NOT_FOUND);
		}
	}

	@Transactional(isolation = Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,rollbackFor=java.lang.Exception.class)
	public BookRatingDto getBookRating(int id) throws TaskException {
		Optional<Book> book =bookRepository.findById(id);
		if(book.isPresent()) {
//			ResponseEntity<List<Rating>> rating = restTemplate.exchange("http://localhost:8092/book/"+id+"/rating",
//					HttpMethod.GET,null,new ParameterizedTypeReference<List<Rating>>(){});
			
			ResponseEntity<List<Rating>> rating = bookRatingService.bookRating(id);
			BookRatingDto bookRatingDto = bookRatingConverter.entityToDto(new BookRating(book.get(),rating.getBody()));
			return bookRatingDto;
	}else {
		throw new TaskException("No Data",HttpStatus.BAD_REQUEST);
		}
	}

}
