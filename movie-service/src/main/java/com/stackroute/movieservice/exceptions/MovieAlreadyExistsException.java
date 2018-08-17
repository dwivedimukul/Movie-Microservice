package com.stackroute.movieservice.exceptions;

import com.stackroute.movieservice.domain.Movie;

public class MovieAlreadyExistsException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Movie movie;
	
	public MovieAlreadyExistsException(Movie movie) {
		this.movie=movie;
	}
	public String toString(){
	     return movie + " already exists" ;
	}
}
