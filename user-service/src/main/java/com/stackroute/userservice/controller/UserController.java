package com.stackroute.userservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.service.UserServices;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
	
	private UserServices userServiceImpl;
	Logger logger = LoggerFactory.getLogger("BootstrapData");
	
	@Autowired
	public UserController(UserServices userServiceImpl) {
		this.userServiceImpl=userServiceImpl;
	}

	@RequestMapping(value="/users" , method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<?> getAllUsers(){
		try {
			List<User> userList;
			if((userList= userServiceImpl.getAllUsers())!=null) {
				logger.debug("debug");
				logger.error("error");
				logger.warn("warm");
				logger.info("info");
				logger.trace("trace");
				return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
			}
			else {
				throw new UserNotFoundException();
			}
		}
		catch(UserNotFoundException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="save/user" , method=RequestMethod.POST , produces="application/json")
	public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException{
		try {
			User savedUser;
			if((savedUser = userServiceImpl.saveUser(user))!=null) {
				return new ResponseEntity<User>(savedUser,HttpStatus.OK);
			}
			else {
				throw new UserAlreadyExistsException(user);
			}
		}
		catch(UserAlreadyExistsException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.OK);
		}
		
	}
	
	
	@RequestMapping(value="delete/user/{userId}" , method=RequestMethod.DELETE , produces="application/json")
	public ResponseEntity<?> deleteUser(@PathVariable int userId) throws UserNotFoundException{ 
		try {	
			User user;
			if((user= userServiceImpl.deleteUser(userId))!=null) {
				return new ResponseEntity<User>(user,HttpStatus.OK);
			}
			else {
				throw new UserNotFoundException(userId);
			}
		}
		catch(UserNotFoundException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="update/user/{userId}" , method=RequestMethod.PUT , produces="application/json")
	public ResponseEntity<?> updateUser(@PathVariable int userId ,@RequestBody User user) throws UserNotFoundException{
		try {	
			User updatedUser;
			if((updatedUser = userServiceImpl.updateUser(userId,user))!=null) {
				return new ResponseEntity<User>(updatedUser,HttpStatus.OK);
			}
			else {
				throw new UserNotFoundException(userId);
			}
		}
		catch(UserNotFoundException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="searchId/movie/{movieId}" , method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<?> getMovieById(@PathVariable int userId)  throws UserNotFoundException{
		try {	
			User user;
			if((user= userServiceImpl.getUserById(userId))!=null) {
				return new ResponseEntity<User>(user,HttpStatus.OK);
			}
			else {
				throw new UserNotFoundException(userId);
			}
		}
		catch(UserNotFoundException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.OK);
		}
	}
	
	
		
}
