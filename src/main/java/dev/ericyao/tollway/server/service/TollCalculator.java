package dev.ericyao.tollway.server.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import dev.ericyao.tollway.server.entity.Transaction;

// TODO: may involve db via tollRepository
@Service
public class TollCalculator {
	
	Random rand = new Random();
	
	public int calculate(Transaction trans) {
		return rand.nextInt(1000);
	}
}
