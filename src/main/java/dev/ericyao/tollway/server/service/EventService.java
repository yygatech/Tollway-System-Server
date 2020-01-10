package dev.ericyao.tollway.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ericyao.tollway.server.entity.Transaction;
import dev.ericyao.tollway.server.object.Event;

@Service
public class EventService {
	
	@Autowired
	TransactionService tService;
	
	@Autowired
	TollCalculator tc;
	
	public Transaction processEvent(Event event) {
		
		Transaction trans = new Transaction(event);
		
		// calculate toll
		trans.setTollInCents(tc.calculate(trans));
		
		// TODO: toll charge/bill service
		
		// save transaction
		tService.saveTransaction(trans);
		
		return trans;
	}
	
}
