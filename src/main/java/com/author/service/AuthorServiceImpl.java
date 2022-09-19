package com.author.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.modal.Book;
import com.author.modal.User;
import com.author.exception.ResourceNotFoundException;

@Service
public class AuthorServiceImpl implements IAuthorService{

	@Autowired
	IAuthorRepository authorRepository;
	
	@Autowired
	IUserRepository userRepository;
	
	@Override
	public Integer saveAuthor(Book author) {
		Book saveAuthor = authorRepository.save(author);
		return saveAuthor.getId();
	}

	@Override
	public List<Book> getAuthor() {
		return authorRepository.findAll();
	}

	@Override
	public Optional<Book> getAuthorById(Integer id) {
		return authorRepository.findById(id);
	}

	@Override
	public void deleteBook(Integer studentId) {
	 authorRepository.deleteById(studentId);
	}

	@Override
	public Book updateBook(Book book, Integer id) {
		Book existingBook = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
		existingBook.setTitle(book.getTitle());
		existingBook.setAuthor(book.getAuthor());
		existingBook.setCategory(book.getCategory());
		existingBook.setImage(book.getImage());
		existingBook.setPrice(book.getPrice());
		existingBook.setPublisher(book.getPublisher());
		existingBook.setPublishDate(book.getPublishDate());
		existingBook.setActive(book.getActive());
		existingBook.setContent(book.getContent());
		
		authorRepository.save(existingBook);
		return existingBook;
	}

	@Override
	public Integer blockBook(Integer id, Boolean blockBook) {
		
		return authorRepository.blockBook(blockBook, id);
		
	}

	@Override
	public List<Book> getUnBlockBooks() {
		return authorRepository.getAllUnBLockBooks();
		
	}

	@Override
	public List<Book> getBlockBooks() {
		
		return authorRepository.getAllBLockBooks();
	}


}
