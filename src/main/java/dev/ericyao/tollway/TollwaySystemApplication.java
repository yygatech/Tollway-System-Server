package dev.ericyao.tollway;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.ericyao.tollway.server.dao.TransactionRepository;
import dev.ericyao.tollway.server.entity.Transaction;

@SpringBootApplication
public class TollwaySystemApplication {

	@Autowired
	TransactionRepository transRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(TollwaySystemApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner() {
		
		return args -> {
			Transaction trans = new Transaction(
					"APTX4869", true, 99999L, 1, 11111L, 6, new Date());
			
			transRepo.save(trans);
		};
	}

}
