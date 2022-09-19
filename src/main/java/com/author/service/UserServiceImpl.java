package com.author.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.author.modal.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Override
	public Integer createUser(User user) {
		User saveUser = userRepository.save(user);
		return saveUser.getId();
	}

	@Override
	public Boolean logInUser(String username, String password) {
		List<User> loginUser = userRepository.findbyNameAndPasswrd(username, password);
		System.out.println("login User " + loginUser);
		if (loginUser.isEmpty()) {
			return false;
		}
		return true;
	}

}
