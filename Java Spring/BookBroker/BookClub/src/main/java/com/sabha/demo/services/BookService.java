package com.sabha.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sabha.demo.models.Book;
import com.sabha.demo.repositories.BookRepository;

@Service
public class BookService {
	@Autowired
	private BookRepository bookRepository;
	
	// return books
	public List<Book> allBooks() {
		return bookRepository.findAll();
	}
	// add book
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	// update book
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	// delete book
	public void deleteBook(Long id)	{
		bookRepository.deleteById(id);
	}
	// retrieves book
	public Book findbook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
}
