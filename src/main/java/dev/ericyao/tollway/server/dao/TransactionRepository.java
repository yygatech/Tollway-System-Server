package dev.ericyao.tollway.server.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.ericyao.tollway.server.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
}
