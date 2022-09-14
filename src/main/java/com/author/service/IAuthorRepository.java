package com.author.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.author.modal.Book;

public interface IAuthorRepository extends JpaRepository<Book, Integer>{

}
