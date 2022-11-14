package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService {

	@Autowired
	MovieRepository repo;
	
	public List<Movie> showMovies() {
		return repo.findAll();
	}
	
	public List<Movie> searchByGenre(String genre) {
		return repo.searchByMovieGenre(genre);
	}
	
	public void addMovie(Movie movie) {
		repo.save(movie);
	}
	
	public Movie searchMovie(int movieId) {
		return repo.findById(movieId).get();
	}
}
