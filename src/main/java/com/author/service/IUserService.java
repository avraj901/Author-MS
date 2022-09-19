package com.author.service;

import java.util.List;

import com.author.modal.User;

public interface IUserService {

	Integer createUser(User user);
	
	Boolean logInUser(String username, String Password);
}
