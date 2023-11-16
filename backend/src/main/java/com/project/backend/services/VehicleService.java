package com.project.backend.services;

import com.project.backend.models.entities.Reserve;
import com.project.backend.models.entities.Vehicle;
import com.project.backend.models.repositories.ReserveRepository;
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
  private final ReserveRepository reserveRepository;

  /**
   * Instantiates a new Vehicle service.
   *
   * @param vehicleRepository the vehicle repository
   * @param reserveRepository the reserve repository
   */
  @Autowired
  public VehicleService(VehicleRepository vehicleRepository, ReserveRepository reserveRepository) {
    this.vehicleRepository = vehicleRepository;
    this.reserveRepository = reserveRepository;
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
   * Remove by id optional.
   *
   * @param id the id
   * @return the optional
   */
  public Optional<Vehicle> removeById(Long id) {
    Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

    if (vehicleOptional.isPresent()) {
      if (vehicleOptional.get().getReserve() == null) {
        vehicleRepository.deleteById(id);
      }
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

  /**
   * Insert reserve optional.
   *
   * @param vehicleId the vehicle id
   * @param reserve   the reserve
   * @return the optional
   */
  public Optional<Reserve> insertReserve(Long vehicleId, Reserve reserve) {
    Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);

    if (optionalVehicle.isPresent()) {
      Vehicle vehicle = optionalVehicle.get();
      reserve.setVehicle(vehicle);
      Reserve newReserve = reserveRepository.save(reserve);
      return Optional.of(newReserve);
    }

    return Optional.empty();
  }

  /**
   * Remove reserve by id optional.
   *
   * @param vehicleId the vehicle id
   * @return the optional
   */
  public Optional<Reserve> removeReserveById(Long vehicleId) {
    Optional<Vehicle> optionalVehicle = vehicleRepository.findById(vehicleId);

    if (optionalVehicle.isPresent()) {
      Vehicle vehicle = optionalVehicle.get();
      Optional<Reserve> optionalReserve = reserveRepository.findById(vehicle.getReserve().getId());

      if (optionalReserve.isPresent()) {
        vehicle.setReserve(null);
        Reserve reserve = optionalReserve.get();
        reserveRepository.deleteById(reserve.getId());

        return Optional.of(reserve);
      }
    }

    return Optional.empty();
  }


}
