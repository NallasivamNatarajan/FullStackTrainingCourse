package com.htc.bookservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.htc.bookservice.entity.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

}
