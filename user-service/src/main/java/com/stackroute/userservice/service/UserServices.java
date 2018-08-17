package com.stackroute.userservice.service;

import java.util.List;

import com.stackroute.userservice.domain.User;

public interface UserServices {
	
	public User saveUser(User user); 
	
	public List<User> getAllUsers(); 
	
	public User getUserById(int userId);
	
	public User deleteUser(int userId);
	
	public User updateUser(int userId,User user);
	

}
