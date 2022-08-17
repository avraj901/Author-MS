package com.author.service;

import java.util.List;
import java.util.Optional;

import com.author.modal.Author;

public interface IAuthorService {

	Integer saveAuthor(Author author);

	public List<Author> getAuthor();

	public Optional<Author> getAuthorById(Integer id);
}
