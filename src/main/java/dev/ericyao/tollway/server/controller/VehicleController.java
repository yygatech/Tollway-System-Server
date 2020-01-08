package dev.ericyao.tollway.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.ericyao.tollway.server.entity.Vehicle;
import dev.ericyao.tollway.server.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleController {
	
	@Autowired
	VehicleService vService;
	
	@GetMapping
	public String displayVehicles(Model model) {
		Iterable<Vehicle> vehicles = vService.getVehicles();
		model.addAttribute("vehicles", vehicles);
		
		System.out.println("vehicle added to model");
		return "vehicle/vehicle-list";
	}
}
