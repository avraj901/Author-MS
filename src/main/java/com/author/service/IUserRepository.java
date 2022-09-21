package com.author.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.author.modal.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

	@Query(value = "SELECT * FROM USER WHERE username = ?1 AND password = ?2", nativeQuery = true)
	List<User> findbyNameAndPasswrd(String name, String password);
}
