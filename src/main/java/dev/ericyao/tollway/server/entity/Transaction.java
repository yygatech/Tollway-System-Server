package dev.ericyao.tollway.server.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction {
	
	// transaction-related
	private long transId;
	float toll;
	
	
	// car-related
	private boolean registered;
	private long tollId;
	private String vehicleId;
	
	// gate-related
	private int gateType;
	private long gateId;
	private int laneId;
	@Temporal(TemporalType.TIMESTAMP)
	Date timestamp;
	
	
}
