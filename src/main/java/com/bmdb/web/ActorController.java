package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	public Optional getActor(@PathVariable int ID) {
		Optional<Actor> a = actorRepo.findById(ID);
		return a;
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
	public void deleteActor(@RequestBody Actor a) {
		actorRepo.delete(a);
	}
	
}
