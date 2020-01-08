package dev.ericyao.tollway.server.dto;

import java.util.Date;

public interface DetailedTransaction {
	
	// have property names begin with get
	public Date getTimestamp();
	public long getGateId();
	public String getVehicleId();
	public boolean isRegistered();
	public int getTollInCents();
}
