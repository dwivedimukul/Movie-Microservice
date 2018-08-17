package com.stackroute.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;

@Service
@Primary
public class UserServicesImpl implements UserServices{
	
	
	private UserRepository userRepository;

	@Autowired
	public UserServicesImpl(UserRepository UserRepository) {
		this.userRepository=UserRepository;
	}

	@Override
	public User saveUser(User user) {
		List<User> userList = (List<User>) userRepository.findAll();
		if(userList.contains(user)) {
			return null;
		}
		else {
			User saveUser = userRepository.save(user);
			return saveUser;
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = (List<User>) userRepository.findAll();
		if(userList.isEmpty()) {
			return null;
		}
		else {
			return userList;
		}
	}

	@Override
	public User getUserById(int userId) {
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent()) {
			return null;
		}
		else {
			return user.get();
		}
	}

	@Override
	public User deleteUser(int userId){
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent()) {
			return null;
		}
		else {
			userRepository.deleteById(userId);
			return user.get();
		}
		
	}

	@Override
	public User updateUser(int userId,User user) {
		Optional<User> presentUser = userRepository.findById(userId);
		if(!presentUser.isPresent()) {
			return null;
		}
		else {
			user.setUserId(userId);
			User updatedUser = userRepository.save(user);
			return updatedUser;
		}
	}


	
}
