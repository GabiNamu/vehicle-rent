package com.project.backend;

import com.project.backend.models.entities.Vehicle;
import com.project.backend.models.repositories.VehicleRepository;
import com.project.backend.services.VehicleService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class VehicleServiceTest {
  @Autowired
  VehicleService vehicleService;

  @MockBean
  VehicleRepository vehicleRepository;

  @Test
  public void testVehicleCreation() {
    Vehicle vehicle = new Vehicle();
    vehicle.setBrand("Volkswagen");
    vehicle.setModel("New Beetle");
    vehicle.setColor("Black");
    vehicle.setLicensePlate("LSN4I49");
    vehicle.setManufacturingYear(2023);

    Vehicle vehicleToReturn = new Vehicle();
    vehicleToReturn.setId(123L);
    vehicleToReturn.setBrand(vehicle.getBrand());
    vehicleToReturn.setModel(vehicle.getModel());
    vehicleToReturn.setColor(vehicle.getColor());
    vehicleToReturn.setLicensePlate(vehicle.getLicensePlate());
    vehicleToReturn.setManufacturingYear(vehicle.getManufacturingYear());

    Mockito.when(vehicleRepository.save(any(Vehicle.class)))
      .thenReturn(vehicleToReturn);

    Vehicle savedVehicle = vehicleService.insert(vehicle);

    Mockito.verify(vehicleRepository).save(any(Vehicle.class));
    
    assertEquals(123L, savedVehicle.getId());
    assertEquals(vehicle.getBrand(), savedVehicle.getBrand());
    assertEquals(vehicle.getModel(), savedVehicle.getModel());
    assertEquals(vehicle.getColor(), savedVehicle.getColor());
    assertEquals(vehicle.getLicensePlate(), savedVehicle.getLicensePlate());
    assertEquals(vehicle.getManufacturingYear(), savedVehicle.getManufacturingYear());
    assertFalse(vehicle.isReserved());
  }

  @Test
  public void testVehicleGetAll() {

  }
}
