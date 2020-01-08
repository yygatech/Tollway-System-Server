package dev.ericyao.tollway.server.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ericyao.tollway.server.entity.Vehicle;
import dev.ericyao.tollway.server.service.VehicleService;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleApiController {
	
	@Autowired
	VehicleService vService;
	
	@GetMapping
	public Iterable<Vehicle> getVehicles() {
		return vService.getVehicles();
	}
	
	@GetMapping("/{id}")
	public Vehicle getVehicleById(@PathVariable("id") String id) {
		return vService.getVehicleById(id);
	}
}
