package com.author.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.author.modal.Book;
import com.author.service.IAuthorService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuthorController {

	@Autowired
	IAuthorService authorService;

	@PostMapping("/savebook")
	public Integer createBook(@RequestBody Book book) {
		Integer id = authorService.saveAuthor(book);
		return id;
	}

	@GetMapping("/getallbooks")
	public List<Book> getBooks() {
		return authorService.getAuthor();
	}

	@GetMapping("/getbook/{id}")
	public Optional<Book> getBook(@PathVariable Integer id) {
		return authorService.getAuthorById(id);
	}

	@DeleteMapping("/deletebook/{id}")
	public ResponseEntity<Book> deleteBookById(@PathVariable Integer id) {
		ResponseEntity<Book> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			authorService.deleteBook(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@PutMapping("/updatebook/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable("id") Integer id, @RequestBody Book book) {
		return new ResponseEntity<Book>(authorService.updateBook(book, id), HttpStatus.OK);
	}
}
