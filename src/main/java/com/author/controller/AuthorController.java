package com.author.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.author.modal.Author;
import com.author.service.IAuthorService;

@RestController
public class AuthorController {

	@Autowired
	IAuthorService authorService;
	
	@PostMapping("/saveauthor")
	public Integer createAuthor(@RequestBody Author author) {
		System.out.println("Author ::"+ author);
		Integer id = authorService.saveAuthor(author);
		return id;
	}
	
	@GetMapping("/getallauthor")
	public List<Author> getAuthors(){
		return authorService.getAuthor();
	}
	
	@GetMapping("getAuthor/{id}")
	public Optional<Author> getAuthor(@PathVariable Integer id){
		return authorService.getAuthorById(id);
	}
}
