package com.project.backend.services;

import com.project.backend.models.entities.Vehicle;
import com.project.backend.models.repositories.VehicleRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Vehicle service.
 */
@Service
public class VehicleService {

  private final VehicleRepository vehicleRepository;

  /**
   * Instantiates a new Vehicle service.
   *
   * @param vehicleRepository the vehicle repository
   */
  @Autowired
  public VehicleService(VehicleRepository vehicleRepository) {
    this.vehicleRepository = vehicleRepository;
  }

  /**
   * Insert vehicle.
   *
   * @param vehicle the vehicle
   * @return the vehicle
   */
  public Vehicle insert(Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }

  /**
   * Reserve optional.
   *
   * @param id the id
   * @return the optional
   */
  public Optional<Vehicle> reserve(Long id) {
    Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

    if (vehicleOptional.isPresent()) {
      Vehicle vehicleFromDb = vehicleOptional.get();
      vehicleFromDb.setReserved(!vehicleFromDb.isReserved());

      Vehicle updatedVehicle = vehicleRepository.save(vehicleFromDb);
      return Optional.of(updatedVehicle);
    }

    return vehicleOptional;
  }

  /**
   * Remove by id optional.
   *
   * @param id the id
   * @return the optional
   */
  public Optional<Vehicle> removeById(Long id) {
    Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

    if (vehicleOptional.isPresent()) {
      vehicleRepository.deleteById(id);
    }

    return vehicleOptional;
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  public List<Vehicle> getAll() {
    return vehicleRepository.findAll();
  }
}
