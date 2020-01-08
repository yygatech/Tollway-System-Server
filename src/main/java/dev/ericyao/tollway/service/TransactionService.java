package dev.ericyao.tollway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import dev.ericyao.tollway.server.dao.TransactionRepository;
import dev.ericyao.tollway.server.entity.Transaction;
import dev.ericyao.tollway.server.entity.Vehicle;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository tRepo;
	
	@Autowired
	VehicleService vService;
	
	@Autowired
	TollCalculator tc;
	
	public Iterable<Transaction> getTransactions() {
		return tRepo.findAll();
	}
	
	public Transaction getTransactionById(long id) {
		return tRepo.findById(id).get();
	}
	
	public Transaction processTransaction(Transaction trans) {
		// check registration
		Long tollTagId = trans.getTollTagId();
		if (tollTagId != null) {	// with toll tag
			trans.setRegistered(true);
			System.out.println("toll tag found");
		} else { 					// without toll tag; check by vehicle id
			Vehicle v = vService.getVehicleById(trans.getVehicleId());
			if (v != null) {		// vehicle found
				trans.setRegistered(true);
				System.out.println("vehicle found by id");
			} else {				// vehicle not found
				trans.setRegistered(false);
				System.out.println("vehicle not found");
			}
		}
		
		// calculate toll
		trans.setToll(tc.calculate(trans));
		
		// TODO: toll charge/bill service
		
		// save to database
		tRepo.save(trans);
		
		return trans;
	}
	
	public boolean deleteTransaction(long id) {
		try {
			tRepo.deleteById(id);
			return true;
		} catch (EmptyResultDataAccessException ex) {
			return false;
		}
	}
}
