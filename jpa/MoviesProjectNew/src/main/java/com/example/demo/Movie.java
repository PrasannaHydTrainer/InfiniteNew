package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	@Column(name="movieId")
	private Integer movieId;
	
	@Column(name="movieName")
	private String movieName;
	
	@Column(name="movieRating")
	private Integer movieRating;
	
	@Column(name="movieGenre")
	private String movieGenre;
	public Integer getMovieId() {
		return movieId;
	}
	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Integer getMovieRating() {
		return movieRating;
	}
	public void setMovieRating(Integer movieRating) {
		this.movieRating = movieRating;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	
	
}
