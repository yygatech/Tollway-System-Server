package dev.ericyao.tollway.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ericyao.tollway.server.dao.GateRepository;
import dev.ericyao.tollway.server.entity.Gate;

@RestController
@RequestMapping("/gate")
public class GateApiController {

	@Autowired
	GateRepository gRepo;
	
	@GetMapping
	public Iterable<Gate> getGates() {
		return gRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Gate getGateById(@PathVariable("id") long id) {
		return gRepo.findById(id).get();
	}
	
}
