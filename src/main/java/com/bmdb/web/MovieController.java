package com.bmdb.web;

import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/api/movies")
public class MovieController {
	
	@Autowired
	private MovieRepo movieRepo;
	
	// List all movies
	@GetMapping("/")
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}
	
	// List all movies by rating
	@GetMapping("")
	public List<Movie> getAllMoviesByRating(@RequestParam String rating) {
		return movieRepo.findByRating(rating);
	}
	
	// Get movie by id
	@GetMapping("/{ID}")
	public Optional<Movie> getMovie(@PathVariable int ID) {
		Optional<Movie> m = movieRepo.findById(ID);
		if (m.isPresent()) {
			return m;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found");
		}
	}
	
	// Add a movie
	@PostMapping("/")
	public Movie addMovie(@RequestBody Movie m) {
		return movieRepo.save(m);
	}
	
	// Update a movie
	@PutMapping("/{ID}")
	public Movie updateMovie(@RequestBody Movie m, @PathVariable int ID) {
		if (ID == m.getID()) {
			return movieRepo.save(m);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie id does not match");
		}
	}
	
	// Delete a movie
	@DeleteMapping("/{ID}")
	public Optional<Movie> deleteMovie(@PathVariable int ID) {
		Optional<Movie> m = movieRepo.findById(ID);
		if (m.isPresent()) {
			movieRepo.deleteById(ID);
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found");
		}
		return m;
	}
	
}
