package com.sdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.model.User;
import com.sdp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepository;
	@Override
	public String adduser(User u) 
	{
		userRepository.save(u);
		return "Registration Successfull";
	}
	@Override
	public User checkuserlogin(String email, String password) 
	{
		return userRepository.checkuserlogin(email, password);
	}

}
