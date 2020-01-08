package dev.ericyao.tollway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dev.ericyao.tollway.server.dao.TransactionRepository;

@SpringBootApplication
public class TollwaySystemApplication {

	@Autowired
	TransactionRepository transRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(TollwaySystemApplication.class, args);
	}

}
