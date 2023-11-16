package com.project.backend.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.backend.models.entities.Reserve;
import com.project.backend.models.entities.Vehicle;

/**
 * The type Vehicle dto.
 */
public record VehicleDto(
    Long id,
    String model,
    String brand,
    String color,
    int manufacturingYear,
    String licensePlate,
    Reserve reserve

) {

  /**
   * To vehicle vehicle.
   *
   * @return the vehicle
   */
  public Vehicle toVehicle() {
    return new Vehicle(id, model, brand, color, manufacturingYear, licensePlate);
  }
}
