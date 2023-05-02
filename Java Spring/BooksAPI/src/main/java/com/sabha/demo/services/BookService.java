package com.sabha.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sabha.demo.models.Book;
import com.sabha.demo.repositories.BookRepository;
import com.sabha.demo.repositories.BookRepository.NestedBookRepository;


@Service
public class BookService {
    // adding the book repository as a dependency
    private final NestedBookRepository bookRepository;
    
    public BookService(NestedBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    public Book updateBook(Long id, String title, String desc, String lang, int pages) {
    	 Book book = bookRepository.findById(id).orElse(null);
         if (book != null) {
             book.setTitle(title);
             book.setDescription(desc);
             book.setLanguage(lang);
             book.setNumberOfPages(pages);
             book = bookRepository.save(book);
         }
         return book;
    }
    public Book deleteBook(Long id) {
    	Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            bookRepository.delete(book);
        }
        return book;
    } 
}
