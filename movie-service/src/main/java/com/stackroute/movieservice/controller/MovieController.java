package com.stackroute.movieservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.exceptions.MovieAlreadyExistsException;
import com.stackroute.movieservice.exceptions.MovieNotFoundException;
import com.stackroute.movieservice.services.MovieServices;

@RestController
@RequestMapping("/api/v1/")
public class MovieController {
	
	private MovieServices movieServiceImpl;
	Logger logger = LoggerFactory.getLogger("BootstrapData");
	
	@Autowired
	public MovieController(MovieServices movieServiceImpl) {
		this.movieServiceImpl=movieServiceImpl;
	}

	@RequestMapping(value="/movies" , method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<?> getAllMovies(){
		try {
			List<Movie> movieList;
			if((movieList= movieServiceImpl.getAllMovies())!=null) {
				logger.debug("debug");
				logger.error("error");
				logger.warn("warm");
				logger.info("info");
				logger.trace("trace");
				return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
			}
			else {
				throw new MovieNotFoundException();
			}
		}
		catch(MovieNotFoundException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="save/movie" , method=RequestMethod.POST , produces="application/json")
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException{
		try {
			Movie savedMovie;
			if((savedMovie = movieServiceImpl.saveMovie(movie))!=null) {
				return new ResponseEntity<Movie>(savedMovie,HttpStatus.OK);
			}
			else {
				throw new MovieAlreadyExistsException(movie);
			}
		}
		catch(MovieAlreadyExistsException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.OK);
		}
		
	}
	
	
	@RequestMapping(value="delete/movie/{movieId}" , method=RequestMethod.DELETE , produces="application/json")
	public ResponseEntity<?> deleteMovie(@PathVariable int movieId) throws MovieNotFoundException{ 
		try {	
			Movie movie;
			if((movie= movieServiceImpl.deleteMovie(movieId))!=null) {
				return new ResponseEntity<Movie>(movie,HttpStatus.OK);
			}
			else {
				throw new MovieNotFoundException(movieId);
			}
		}
		catch(MovieNotFoundException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.OK);
		}
		
	}
	
	@RequestMapping(value="update/movie/{movieId}" , method=RequestMethod.PUT , produces="application/json")
	public ResponseEntity<?> updateMovie(@PathVariable int movieId ,@RequestBody Movie movie) throws MovieNotFoundException{
		try {	
			Movie updatedMovie;
			if((updatedMovie = movieServiceImpl.updateMovie(movieId,movie))!=null) {
				return new ResponseEntity<Movie>(updatedMovie,HttpStatus.OK);
			}
			else {
				throw new MovieNotFoundException(movieId);
			}
		}
		catch(MovieNotFoundException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="searchId/movie/{movieId}" , method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<?> getMovieById(@PathVariable int movieId)  throws MovieNotFoundException{
		try {	
			Movie movie;
			if((movie= movieServiceImpl.getMovieById(movieId))!=null) {
				return new ResponseEntity<Movie>(movie,HttpStatus.OK);
			}
			else {
				throw new MovieNotFoundException(movieId);
			}
		}
		catch(MovieNotFoundException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="searchName/movie/{mname}" , method=RequestMethod.GET , produces="application/json")
	public ResponseEntity<?> getMovieByName(@PathVariable String mname){
		try {
			List<Movie> movieList;
			if((movieList = movieServiceImpl.getMovieByName(mname))!=null) {
				return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
			}
			else {
				throw new MovieNotFoundException(mname);
			}
		}
		catch(MovieNotFoundException e) {
			return new ResponseEntity<String>(e.toString(),HttpStatus.OK);
		}
	}
	
		
}
