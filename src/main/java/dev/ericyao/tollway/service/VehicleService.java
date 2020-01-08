package dev.ericyao.tollway.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.ericyao.tollway.server.dao.VehicleRepository;
import dev.ericyao.tollway.server.entity.Vehicle;

@Service
public class VehicleService {

	@Autowired
	VehicleRepository vRepo;
	
	public Vehicle getVehicleById(String id) {
		try {
			return vRepo.findById(id).get();
		} catch (NoSuchElementException ex) {
			return null;
		}
	}
}
