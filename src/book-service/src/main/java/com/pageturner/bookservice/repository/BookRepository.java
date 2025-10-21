package com.pageturner.bookservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pageturner.bookservice.entity.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	public Optional<Book> findByTitle(String title);
}
