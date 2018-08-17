package com.stackroute.movieservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int movieId;
	private String movieTitle;
	private float movieRating;
	private String movieYor;

}
