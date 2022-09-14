package com.author.service;

import java.util.List;
import java.util.Optional;

import com.author.modal.Book;


public interface IAuthorService {

	Integer saveAuthor(Book author);

	public List<Book> getAuthor();

	public Optional<Book> getAuthorById(Integer id);
	
	public void deleteBook(Integer studentId);
	
	Book updateBook(Book author, Integer id);
}
