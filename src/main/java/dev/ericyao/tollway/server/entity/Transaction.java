package dev.ericyao.tollway.server.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Transaction {
	
	// transaction-related
	@Id
	private long transactionId;
	float toll;
	
	// car-related
	private String vehicleId;
	private boolean registered;
	private long tollTagId;
	
	// gate-related
	private int gateType;
	private long gateId;
	private int laneId;
	@Temporal(TemporalType.TIMESTAMP)
	Date timestamp;
	
	public Transaction() {
		
	}

	public Transaction(String vehicleId, boolean registered, long tollTagId, int gateType, long gateId, int laneId,
			Date timestamp) {
		super();
		this.vehicleId = vehicleId;
		this.registered = registered;
		this.tollTagId = tollTagId;
		this.gateType = gateType;
		this.gateId = gateId;
		this.laneId = laneId;
		this.timestamp = timestamp;
	}

	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public float getToll() {
		return toll;
	}
	public void setToll(float toll) {
		this.toll = toll;
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
	public String getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public int getGateType() {
		return gateType;
	}
	public void setGateType(int gateType) {
		this.gateType = gateType;
	}
	public long getGateId() {
		return gateId;
	}
	public void setGateId(long gateId) {
		this.gateId = gateId;
	}
	public int getLaneId() {
		return laneId;
	}
	public void setLaneId(int laneId) {
		this.laneId = laneId;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
