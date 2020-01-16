package dev.ericyao.tollway.server.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Vehicle {
	
	@Id
	@NotNull
	private String vehicleId;
	private Boolean registered;
	
	public Vehicle() {
		
	}

	public Vehicle(@NotNull String vehicleId) {
		super();
		this.vehicleId = vehicleId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public Boolean isRegistered() {
		return registered;
	}

	public void setRegistered(Boolean registered) {
		this.registered = registered;
	}
	
}
