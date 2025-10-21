/**
 * 
 */
package com.pageturner.bookservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pageturner.bookservice.entity.Book;
import com.pageturner.bookservice.serviceImpl.BookServiceImpl;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/book-service/api")
@Slf4j
public class BookController {
	
	@Autowired
	private BookServiceImpl bookService;
	
	public BookController(BookServiceImpl bookServiceImpl) {
		this.bookService = bookServiceImpl;
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Integer id){
		Optional<Book> book = bookService.findBookById(id);
		if(book.isPresent()) {
			return new ResponseEntity<Book>(book.get(),HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> books = bookService.findAllBooks();
		return new ResponseEntity<List<Book>>(books,HttpStatus.OK);
	}
	
	@PostMapping("/saveBook")
	public ResponseEntity<String> saveBook(@Valid @RequestBody Book book){
		String msg = bookService.saveBook(book);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
