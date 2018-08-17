package com.stackroute.movieservice.exceptions;


public class MovieNotFoundException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	int movieId;
	String mname;
	
	public MovieNotFoundException() {
		
	}
	
	public MovieNotFoundException(int movieId) {
		this.movieId=movieId;
	}
	
	public MovieNotFoundException(String mname) {
		this.mname=mname;
	}
	
	public String toString(){
	     return "Movies not found";
	}
	
}
