package com.sdp.service;

import com.sdp.model.User;

public interface UserService 
{
	public String adduser(User u);
	public User checkuserlogin(String email,String password);
}
