package com.example.homework;

import java.util.List;

public class BookService {
	private iBookRepository bookRepository;

	public BookService(iBookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public Book findBookById(String id) {
		return bookRepository.findById(id);
	}

	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}
}