package com.author.service;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Author> getAuthor() {
		return authorRepository.findAll();
	}

	@Override
	public Optional<Author> getAuthorById(Integer id) {
		return authorRepository.findById(id);
	}

}
