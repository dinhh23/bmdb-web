package com.bmdb.web;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.bmdb.business.Credit;
import com.bmdb.db.CreditRepo;

@CrossOrigin
@RestController
@RequestMapping("/credits")
public class CreditController {
	
	@Autowired
	private CreditRepo creditRepo;
	
	// List all credits
	@GetMapping("/")
	public List<Credit> getAllCredits() {
		return creditRepo.findAll();
	}
	
	// Get credit by id
	@GetMapping("/{ID}")
	public Optional<Credit> getCredit(@PathVariable int ID) {
		Optional<Credit> c = creditRepo.findById(ID);
		if (c.isPresent()) {
			return c;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Credit not found");
		}
	}
		
	
	
	
	// Add a credit
	@PostMapping("/")
	public Credit addCredit(@RequestBody Credit c) {
		return creditRepo.save(c);
	}
	
	// Update a credit
	@PutMapping("/")
	public Credit updateCredit(@RequestBody Credit c) {
		return creditRepo.save(c);
	}
	
	// Delete a credit
	@DeleteMapping("/")
	public Credit deleteCredit(@RequestBody Credit c) {
		creditRepo.delete(c);
		return c;
	}
	
}
