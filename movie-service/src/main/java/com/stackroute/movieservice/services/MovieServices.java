package com.stackroute.movieservice.services;

import java.util.List;

import com.stackroute.movieservice.domain.Movie;

public interface MovieServices {
	
	public Movie saveMovie(Movie movie); 
	
	public List<Movie> getAllMovies(); 
	
	public Movie getMovieById(int movieId);
	
	public Movie deleteMovie(int movieId);
	
	public Movie updateMovie(int movieId,Movie movie);
	
	public List<Movie> getMovieByName(String movie);

}
