package dev.ericyao.tollway.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.ericyao.tollway.server.entity.Transaction;
import dev.ericyao.tollway.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionApiController {
	
	@Autowired
	TransactionService tService;
	
	@GetMapping
	public Iterable<Transaction> getTransactions() {
		return tService.getTransactions();
	}
	
	@GetMapping("/{id}")
	public Transaction getTransactionById(@PathVariable("id") long id) {
		return tService.getTransactionById(id);
	}
	
	@PostMapping(consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Transaction processTransaction(@RequestBody Transaction trans) {
		return tService.processTransaction(trans);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)	// TODO: different result 
	public void deleteTransaction(@PathVariable("id") long id) {
		boolean res = tService.deleteTransaction(id);
	}
}
