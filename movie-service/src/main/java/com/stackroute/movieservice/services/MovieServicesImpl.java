package com.stackroute.movieservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;

@Service
@Primary
public class MovieServicesImpl implements MovieServices{
	
	
	private MovieRepository movieRepository;

	@Autowired
	public MovieServicesImpl(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		List<Movie> movieList = (List<Movie>) movieRepository.findAll();
		if(movieList.contains(movie)) {
			return null;
		}
		else {
			Movie saveMovie = movieRepository.save(movie);
			return saveMovie;
		}
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movieList = (List<Movie>) movieRepository.findAll();
		if(movieList.isEmpty()) {
			return null;
		}
		else {
			return movieList;
		}
	}

	@Override
	public Movie getMovieById(int movieId) {
		Optional<Movie> movie = movieRepository.findById(movieId);
		if(!movie.isPresent()) {
			return null;
		}
		else {
			return movie.get();
		}
	}

	@Override
	public Movie deleteMovie(int movieId){
		Optional<Movie> movie = movieRepository.findById(movieId);
		if(!movie.isPresent()) {
			return null;
		}
		else {
			movieRepository.deleteById(movieId);
			return movie.get();
		}
		
	}

	@Override
	public Movie updateMovie(int movieId,Movie movie) {
		Optional<Movie> presentMovie = movieRepository.findById(movieId);
		if(!presentMovie.isPresent()) {
			return null;
		}
		else {
			movie.setMovieId(movieId);
			Movie updatedMovie = movieRepository.save(movie);
			return updatedMovie;
		}
	}

	@Override
	public List<Movie> getMovieByName(String mname) {
		List<Movie> movieList = movieRepository.getByMovieName(mname);
		if(movieList.isEmpty()) {
			return null;
		}
		else {
			return movieList;
		}
	}


	
}
