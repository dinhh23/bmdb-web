package com.bmdb.web;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieController {
	
	@Autowired
	private MovieRepo movieRepo;
	
	// List all movies
	@GetMapping("/")
	public List<Movie> getAllMovies() {
		return movieRepo.findAll();
	}
	
	// Get movie by id
	@GetMapping("/{ID}")
	public Optional getMovie(@PathVariable int ID) {
		Optional<Movie> m = movieRepo.findById(ID);
		return m;
	}
	
	// Add a movie
	@PostMapping("/")
	public Movie addMovie(@RequestBody Movie m) {
		return movieRepo.save(m);
	}
	
	// Update a movie
	@PutMapping("/")
	public Movie updateMovie(@RequestBody Movie m) {
		return movieRepo.save(m);
	}
	
	// Delete a movie
	@DeleteMapping("/")
	public void deleteMovie(@RequestBody Movie m) {
		movieRepo.delete(m);
	}
	
}
