package com.stackroute.userservice.exception;


public class UserNotFoundException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int movieId;
	String mname;
	
	public UserNotFoundException() {
		
	}
	
	public UserNotFoundException(int movieId) {
		this.movieId=movieId;
	}
	
	public UserNotFoundException(String mname) {
		this.mname=mname;
	}
	
	public String toString(){
	     return "Movies not found";
	}
	
}
