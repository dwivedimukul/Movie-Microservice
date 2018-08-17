package com.stackroute.userservice.exception;

import com.stackroute.userservice.domain.User;

public class UserAlreadyExistsException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	User user;
	
	public UserAlreadyExistsException(User user) {
		this.user=user;
	}
	public String toString(){
	     return user + " already exists" ;
	}
}
