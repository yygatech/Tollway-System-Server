package dev.ericyao.tollway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ericyao.tollway.server.dao.GateRepository;
import dev.ericyao.tollway.server.entity.Gate;

@Service
public class GateService {
	
	@Autowired
	GateRepository gRepo;
	
	public Gate getGateById(long id) {
		return gRepo.findById(id).get();
	}
}
