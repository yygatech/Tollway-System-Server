package dev.ericyao.tollway.server.dao;

import java.util.NoSuchElementException;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.ericyao.tollway.server.entity.Vehicle;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {

}
