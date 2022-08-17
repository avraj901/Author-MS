package com.author.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.modal.Author;

@Service
public class AuthorServiceImpl implements IAuthorService{

	@Autowired
	IAuthorRepository authorRepository;
	
	@Override
	public Integer saveAuthor(Author author) {
		Author saveAuthor = authorRepository.save(author);
		return saveAuthor.getId();
	}

}
