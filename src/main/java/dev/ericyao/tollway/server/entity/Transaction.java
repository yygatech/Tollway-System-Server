package dev.ericyao.tollway.server.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction {
	
	// transaction-related
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_gen")
	@SequenceGenerator(name = "transaction_gen", sequenceName = "transaction_seq", allocationSize = 1)
	@NotNull
	private long transactionId;
	float toll;
	
	// car-related
	@NotNull
	private String vehicleId;
	private boolean registered;
	private Long tollTagId;
	
	// gate-related
	private int gateType;
	@NotNull
	private long gateId;
	@NotNull
	private int laneId;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	Date timestamp;
	
	public Transaction() {
		
	}

	public Transaction(String vehicleId, boolean registered, Long tollTagId, int gateType, long gateId, int laneId,
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
	public Long getTollTagId() {
		return tollTagId;
	}
	public void setTollTagId(Long tollTagId) {
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
