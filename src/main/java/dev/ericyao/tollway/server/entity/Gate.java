package dev.ericyao.tollway.server.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Gate {
	
	@Id
	@NotNull
	private long gateId;
	@NotNull
	private int tollInCents;
	
	public Gate() {
		
	}

	public Gate(@NotNull long gateId, int tollInCents) {
		super();
		this.gateId = gateId;
		this.tollInCents = tollInCents;
	}

	public long getGateId() {
		return gateId;
	}

	public void setGateId(long gateId) {
		this.gateId = gateId;
	}

	public int getTollInCents() {
		return tollInCents;
	}

	public void setTollInCents(int tollInCents) {
		this.tollInCents = tollInCents;
	}
	
}
