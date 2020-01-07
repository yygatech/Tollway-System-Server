package dev.ericyao.tollway.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.ericyao.tollway.server.Server;
import dev.ericyao.tollway.server.ServerQueue;
import dev.ericyao.tollway.server.dao.TransactionRepository;
import dev.ericyao.tollway.server.entity.Transaction;

@RestController
@RequestMapping("/server")
public class ServerMainApiController {
	
	@Autowired
	Server server;
	
	@Autowired
	ServerQueue serverQueue;
	
	@Autowired
	TransactionRepository transRepo;
	
	@GetMapping
	public Iterable<Transaction> getTransactions() {
		return transRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Transaction getTransactionById(@PathVariable("id") long id) {
		return transRepo.findById(id).get();
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Transaction processRequest(@RequestBody Transaction trans) {
		
		// calculate toll
		float toll = calculateToll(trans);
		trans.setToll(toll);
		
		// save to database
		transRepo.save(trans);
		
		return trans;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTransaction(@PathVariable("id") long id) {
		try {
			transRepo.deleteById(id);
		} catch (EmptyResultDataAccessException ex) {
//			ex.printStackTrace();
		}
	}
	
	// TODO: toll calculator
	private float calculateToll(Transaction trans) {
		return 0.1f;
	}
}
