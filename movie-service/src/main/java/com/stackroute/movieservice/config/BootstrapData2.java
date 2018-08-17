package com.stackroute.movieservice.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;

@Configuration
public class BootstrapData2 implements CommandLineRunner{
	
	
	private MovieRepository movieRepository;
	
	@Autowired
	public BootstrapData2(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
	}
	
	
	
	@Override
	public void run(String... args) throws Exception {
		Movie movie1 = new Movie(1,"Flash",3.0f,"2009");
		movieRepository.save(movie1);
		
		Movie movie2 = Movie.builder()
				 .movieTitle("Arrow")
				 .movieRating(3.5f)
				 .movieYor("2004")
				 .build();
		movieRepository.save(movie2);
		
	}




}
