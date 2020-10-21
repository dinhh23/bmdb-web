package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Actor;
import com.bmdb.db.ActorRepo;

@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorController {
	
	@Autowired
	private ActorRepo actorRepo;
	
	// List all actors
	@GetMapping("/")
	public List<Actor> getAllActors() {
		return actorRepo.findAll();
	}
	
	// Get actor by id
	@GetMapping("/{ID}")
	public Optional<Actor> getActor(@PathVariable int ID) {
		Optional<Actor> a = actorRepo.findById(ID);
		if (a.isPresent()) {
			return a;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Actor not found");
		}
		
	}
	
	// Add a actor
	@PostMapping("/")
	public Actor addActor(@RequestBody Actor a) {
		return actorRepo.save(a);
	}
	
	// Update a actor
	@PutMapping("/")
	public Actor updateActor(@RequestBody Actor a) {
		return actorRepo.save(a);
	}
	
	// Delete a actor
	@DeleteMapping("/")
	public Actor deleteActor(@RequestBody Actor a) {
		actorRepo.delete(a);
		return a;
	}
	
}
