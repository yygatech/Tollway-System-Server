package dev.ericyao.tollway.server.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.ericyao.tollway.server.entity.Gate;

@Repository
public interface GateRepository extends CrudRepository<Gate, Long> {

}
