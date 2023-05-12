package com.sabha.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.sabha.demo.models.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	// this method retrieves all the books from the database
	List<Book> findAll();
}
