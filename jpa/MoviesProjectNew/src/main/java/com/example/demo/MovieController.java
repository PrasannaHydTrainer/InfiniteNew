package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

	 @Autowired
	 private MovieService service;
	 
	 @PostMapping("/movies/addMovies")
	 public void addMovie(@RequestBody Movie movie) {
		  service.addMovie(movie);
	 }
	 @RequestMapping("/search/{movieId}")
	  public Movie show(@PathVariable int movieId) {
			return service.searchMovie(movieId);
	}
	
	 @RequestMapping("/searchByGenre/{genreName}")
	 public List<Movie> searchByGenre(@PathVariable String genreName) {
		 return service.searchByGenre(genreName);
	 }
	@GetMapping("/")
	public List<Movie> list() {
	    return service.showMovies();
	}
}
