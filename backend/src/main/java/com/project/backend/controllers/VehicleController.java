package com.project.backend.controllers;

import com.project.backend.controllers.dto.ResponseDto;
import com.project.backend.controllers.dto.VehicleDto;
import com.project.backend.models.entities.Vehicle;
import com.project.backend.services.VehicleService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * The type Vehicle controller.
 */
@RestController
@RequestMapping(value = "/")
public class VehicleController {

  private final VehicleService vehicleService;

  /**
   * Instantiates a new Vehicle controller.
   *
   * @param vehicleService the vehicle service
   */
  @Autowired
  public VehicleController(VehicleService vehicleService) {
    this.vehicleService = vehicleService;
  }

  /**
   * Create response entity.
   *
   * @param vehicleDto the vehicle dto
   * @return the response entity
   */
  @PostMapping()
  public ResponseEntity<ResponseDto<Vehicle>> create(@RequestBody VehicleDto vehicleDto) {
    Vehicle newVehicle = vehicleService.insert(vehicleDto.toVehicle());
    ResponseDto<Vehicle> responseDto = new ResponseDto<>("Veículo criado com sucesso!", newVehicle);
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
  }

  /**
   * Update response entity.
   *
   * @param vehicleId the vehicle id
   * @return the response entity
   */
  @PutMapping("/{vehicleId}")
  public ResponseEntity<ResponseDto<Vehicle>> update(@PathVariable Long vehicleId) {
    Optional<Vehicle> optionalVehicle = vehicleService.reserve(vehicleId);

    if (optionalVehicle.isEmpty()) {
      ResponseDto<Vehicle> responseDto = new ResponseDto<>(
        String.format("Não foi encontrado o veículo de ID %d", vehicleId), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }

    ResponseDto<Vehicle> responseDto = new ResponseDto<>(
      "Veículo atualizado com sucesso!", optionalVehicle.get());
    return ResponseEntity.ok(responseDto);
  }

  /**
   * Remove by id response entity.
   *
   * @param vehicleId the vehicle id
   * @return the response entity
   */
  @DeleteMapping("/{vehicleId}")
  public ResponseEntity<ResponseDto<Vehicle>> removeById(@PathVariable Long vehicleId) {
    Optional<Vehicle> optionalVehicle = vehicleService.removeById(vehicleId);

    if (optionalVehicle.isEmpty() || optionalVehicle.get().isReserved()) {
      ResponseDto<Vehicle> responseDto = new ResponseDto<>(
        String.format("Não foi possível deletar o veículo de ID %d", vehicleId), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }

    ResponseDto<Vehicle> responseDto = new ResponseDto<>("Veículo removido com sucesso!", null);
    return ResponseEntity.ok(responseDto);
  }

  /**
   * Gets all.
   *
   * @return the all
   */
  @GetMapping()
  public List<VehicleDto> getAll() {
    List<Vehicle> allVehicles = vehicleService.getAll();
    return allVehicles.stream()
      .map((vehicle) -> new VehicleDto(vehicle.getId(), vehicle.getModel(), vehicle.getBrand(), vehicle.getColor(), vehicle.getManufacturingYear(), vehicle.getLicensePlate(), vehicle.isReserved()))
      .collect(Collectors.toList());
  }
}
