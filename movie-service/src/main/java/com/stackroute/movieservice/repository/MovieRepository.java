package com.stackroute.movieservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.movieservice.domain.Movie;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer>{
	
	public Movie getByMovieId(int movieId);
//	@Query("SELECT * FROM Movie movie WHERE movie.movieTitle LIKE ?1")
	public List<Movie> getByMovieTitle(String movieTitle);
	public List<Movie> getByMovieRating(String movieRating);
	public List<Movie> getByMovieYor(String movieYor);
	
	@Query("SELECT m FROM Movie m WHERE m.movieTitle LIKE :mname%")
	public List<Movie> getByMovieName(@Param("mname") String mname);
	

}
