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
	private int gateType;
	
	public Gate() {
		
	}

	public Gate(@NotNull long gateId, @NotNull int gateType) {
		super();
		this.gateId = gateId;
		this.gateType = gateType;
	}

	public long getGateId() {
		return gateId;
	}

	public void setGateId(long gateId) {
		this.gateId = gateId;
	}

	public int getGateType() {
		return gateType;
	}

	public void setGateType(int gateType) {
		this.gateType = gateType;
	}
	
	
}
