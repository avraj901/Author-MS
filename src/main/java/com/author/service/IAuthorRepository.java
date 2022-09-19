package com.author.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.author.modal.Book;

public interface IAuthorRepository extends JpaRepository<Book, Integer> {

	@Modifying
	@Transactional
	@Query(value = "UPDATE author.book b set b.block_book = :blockBook where b.id = :id", nativeQuery = true)
	Integer blockBook(Boolean blockBook, Integer id);

	
	@Query(value = "SELECT * FROM author.book WHERE block_book=false", nativeQuery = true)
	List<Book> getAllUnBLockBooks();
	
	@Query(value = "SELECT * FROM author.book WHERE block_book=true", nativeQuery = true)
	List<Book> getAllBLockBooks();

}
