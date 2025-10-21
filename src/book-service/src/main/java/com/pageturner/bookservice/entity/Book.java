package com.pageturner.bookservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	@NotBlank(message = "Title cannot be blank")
	@Size(min = 3, max = 100, message = "Title must be 3-100 characters")
	private String title;
	
	@Column(nullable = false)
	@NotBlank(message = "Author cannot be empty")
	@Size(min = 2, max = 50, message = "Author name between 2 to 50")
	private String author;
	
	@NotBlank(message = "ISBN cannot be empty")
	@Pattern(
	    regexp = "^(97(8|9))?\\-?\\d{1,5}\\-?\\d{1,7}\\-?\\d{1,7}\\-?[0-9X]$",
	    message = "ISBN must be a valid format like 0-306-40615-2"
	)
	@Column(nullable = false, unique = true)
	private String isbn;

	@Column
	@NotNull(message = "Published date cannot be null")
	@PastOrPresent(message = "Published date cannot be in the future")
	private LocalDate publishedDate;
	

	@Column(nullable = false)
	@NotNull(message = "Available copies cannot be null")
	@Min(value = 0, message = "Available copies cannot be negative")
	private Integer availableCopies;
		
}
