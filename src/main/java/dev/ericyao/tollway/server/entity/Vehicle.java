package dev.ericyao.tollway.server.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Vehicle {
	
	@Id
	@NotNull
	private String vehicleId;
	private boolean registered;
	private long tollTagId;
	
	public Vehicle() {
		
	}

	public Vehicle(@NotNull String vehicleId, boolean registered, long tollTagId) {
		super();
		this.vehicleId = vehicleId;
		this.registered = registered;
		this.tollTagId = tollTagId;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
	}

	public long getTollTagId() {
		return tollTagId;
	}

	public void setTollTagId(long tollTagId) {
		this.tollTagId = tollTagId;
	}
	
	
}
