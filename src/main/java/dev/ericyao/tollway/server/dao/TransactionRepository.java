package dev.ericyao.tollway.server.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.ericyao.tollway.server.dto.DetailedTransaction;
import dev.ericyao.tollway.server.entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
	@Query(nativeQuery = true,
			value = "SELECT t.timestamp AS timestamp, t.gate_id AS gateId, t.vehicle_id AS vehicleId, v.registered AS registered, t.toll_in_cents AS tollInCents " + 
					"FROM transaction t LEFT JOIN vehicle v ON t.vehicle_id = v.vehicle_id " + 
					"ORDER BY timestamp DESC " +
					"LIMIT 20")
	public Iterable<DetailedTransaction> getDetailedTransactions();
}
