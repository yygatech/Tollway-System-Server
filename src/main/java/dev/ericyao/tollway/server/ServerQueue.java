package dev.ericyao.tollway.server;

import java.util.concurrent.LinkedBlockingQueue;

import org.springframework.stereotype.Component;

import dev.ericyao.tollway.server.entity.Transaction;

@Component
public class ServerQueue extends LinkedBlockingQueue<Transaction>  {
	
	
}
