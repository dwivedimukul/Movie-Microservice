package com.stackroute.movieservice.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;

import com.stackroute.movieservice.domain.Movie;
import com.stackroute.movieservice.repository.MovieRepository;

@Primary
@Configuration
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent>{
	
	
	private MovieRepository movieRepository;
	
	@Autowired
	public BootstrapData(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
	}
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		Movie movie1 = new Movie(1,"Avengers",3.0f,"2009");
		movieRepository.save(movie1);
		Movie movie2 = new Movie(2,"Avengers",3.0f,"2009");
		movieRepository.save(movie2);
		
		Movie movie3 = Movie.builder()
				 .movieTitle("Antman")
				 .movieRating(3.5f)
				 .movieYor("2004")
				 .build();
		movieRepository.save(movie3);
		
		Logger logger = LoggerFactory.getLogger("Controller");
		logger.debug("debug");
		logger.error("error");
		logger.warn("warm");
		logger.info("info");
		logger.trace("trace");
		
		
	}

}
