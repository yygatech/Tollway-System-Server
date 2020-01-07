package dev.ericyao.tollway.server;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

@Component
public class Server {
	
	private int id;
	private long counter;
	
	private BlockingQueue<String> reqQueue;
	
	public Server() {
		counter = 0;
		reqQueue = new LinkedBlockingQueue<>();
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

	public BlockingQueue<String> getReqQueue() {
		return reqQueue;
	}
	
	
}
