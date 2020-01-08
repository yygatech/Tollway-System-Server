package dev.ericyao.tollway.server.controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ericyao.tollway.server.dao.VehicleRepository;
import dev.ericyao.tollway.server.entity.Vehicle;

@RestController
@RequestMapping("/vehicle")
public class VehicleApiController {
	
	@Autowired
	VehicleRepository vRepo;
	
	@GetMapping
	public Iterable<Vehicle> getVehicles() {
		return vRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Vehicle getVehicleById(@PathVariable("id") String id) {
		try {
			return vRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}
}
