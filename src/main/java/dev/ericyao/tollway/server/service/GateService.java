package dev.ericyao.tollway.server.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ericyao.tollway.server.dao.GateRepository;
import dev.ericyao.tollway.server.entity.Gate;

@Service
public class GateService {
	
	@Autowired
	GateRepository gRepo;
	
	public Iterable<Gate> getGates() {
		return gRepo.findAll();
	}
	
	public Gate getGateById(long id) {
		try {
			return gRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}
}
