package dev.ericyao.tollway.server;

import org.springframework.stereotype.Component;

@Component
public class Server {
	
	private int id;
	private long counter;
	
	public Server() {
		counter = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCounter() {
		return counter;
	}
	
}
