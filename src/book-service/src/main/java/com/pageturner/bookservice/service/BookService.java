package com.pageturner.bookservice.service;

import java.util.List;
import java.util.Optional;

import com.pageturner.bookservice.entity.Book;

public interface BookService {
	public String saveBook(Book book);
	public Optional<Book> findBookById(Integer id);
	public List<Book> findAllBooks();
	public String deleteBook(Integer id);
}
