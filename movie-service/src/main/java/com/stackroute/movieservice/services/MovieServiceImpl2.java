package com.stackroute.movieservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.stackroute.movieservice.domain.Movie;

@Service
public class MovieServiceImpl2 implements MovieServices{

	@Override
	public Movie saveMovie(Movie movie) {
		System.out.println("Save");
		return null;
	}

	@Override
	public List<Movie> getAllMovies() {
		System.out.println("Save");
		return null;
	}

	@Override
	public Movie getMovieById(int movieId) {
		System.out.println("Save");
		return null;
	}

	@Override
	public Movie deleteMovie(int movieId) {
		System.out.println("Save");
		return null;
	}

	@Override
	public Movie updateMovie(int movieId, Movie movie) {
		System.out.println("Save");
		return null;
	}

	@Override
	public List<Movie> getMovieByName(String movie) {
		System.out.println("Save");
		return null;
	}

}
