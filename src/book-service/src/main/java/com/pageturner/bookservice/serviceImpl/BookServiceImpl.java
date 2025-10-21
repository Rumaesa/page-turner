package com.pageturner.bookservice.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pageturner.bookservice.entity.Book;
import com.pageturner.bookservice.repository.BookRepository;
import com.pageturner.bookservice.service.BookService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	@Override
	public String saveBook(Book book) {
		Optional<Book> existingBook = bookRepository.findByTitle(book.getTitle());
		if(existingBook.isEmpty()) {
			Book savedBook = bookRepository.save(book);
			return "saved book in DB with id :: "+savedBook.getId();
		} else {			
			return "Book already exist with id :: "+existingBook.get().getId();
		}
	}

	@Override
	public Optional<Book> findBookById(Integer id) {
//		Optional<Book> book = bookRepository.findById(id);
//		if(book.isPresent()) {
//			return book;
//		} else {
//			return Optional.empty();
//		}
//		suggested by gpt:
		return bookRepository.findById(id);
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> books = bookRepository.findAll();
		return books;
	}

	@Override
	public String deleteBook(Integer id) {
		Optional<Book> book = bookRepository.findById(id);
		if(book.isPresent()) {
			bookRepository.deleteById(id);
			return "Deleted book data with id :: "+id;
		} else {
			return "book with id :: "+id+" does not exist!";
		}
	}

}
