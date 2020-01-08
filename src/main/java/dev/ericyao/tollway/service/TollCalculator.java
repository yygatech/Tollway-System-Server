package dev.ericyao.tollway.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import dev.ericyao.tollway.server.entity.Transaction;

// TODO: may involve db via tollRepository
@Service
public class TollCalculator {
	
	Random rand = new Random();
	
	public float calculate(Transaction trans) {
		return rand.nextFloat() * 10;
	}
}
