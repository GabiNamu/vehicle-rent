package com.project.backend.controllers;

import com.project.backend.controllers.dto.ReserveDto;
import com.project.backend.controllers.dto.ResponseDto;
import com.project.backend.controllers.dto.VehicleDto;
import com.project.backend.models.entities.Reserve;
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
   * Remove by id response entity.
   *
   * @param vehicleId the vehicle id
   * @return the response entity
   */
  @DeleteMapping("/{vehicleId}")
  public ResponseEntity<ResponseDto<Vehicle>> removeById(@PathVariable Long vehicleId) {
    Optional<Vehicle> optionalVehicle = vehicleService.removeById(vehicleId);

    if (optionalVehicle.isEmpty() || optionalVehicle.get().getReserve() != null) {
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
      .map((vehicle) -> new VehicleDto(
        vehicle.getId(),
        vehicle.getModel(),
        vehicle.getBrand(),
        vehicle.getColor(),
        vehicle.getManufacturingYear(),
        vehicle.getLicensePlate(),
        vehicle.getReserve()))
      .collect(Collectors.toList());
  }

  /**
   * Create reserve response entity.
   *
   * @param vehicleId  the vehicle id
   * @param reserveDto the reserve dto
   * @return the response entity
   */
  @PostMapping("/{vehicleId}/reserve")
  public ResponseEntity<ResponseDto<Reserve>> createReserve(@PathVariable Long vehicleId, @RequestBody ReserveDto reserveDto) {
    Optional<Reserve> newReserve = vehicleService.insertReserve(vehicleId, reserveDto.toReserve());
    if (newReserve.isEmpty()) {
      ResponseDto<Reserve> responseDto = new ResponseDto<>(
          String.format("Não foi possível reservar o veículo de ID %d", vehicleId), null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }
    ResponseDto<Reserve> responseDto = new ResponseDto<>("Reserva criado com sucesso!", newReserve.get());
    return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
  }

  /**
   * Remove reserve by id response entity.
   *
   * @param vehicleId the vehicle id
   * @return the response entity
   */
  @DeleteMapping("/{vehicleId}/reserve")
  public ResponseEntity<ResponseDto<Reserve>> removeReserveById(@PathVariable Long vehicleId) {
    Optional<Reserve> optionalReserve = vehicleService.removeReserveById(vehicleId);

    if (optionalReserve.isEmpty()) {
      ResponseDto<Reserve> responseDto = new ResponseDto<>("Não foi possível deletar a reserva", null);
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
    }

    ResponseDto<Reserve> responseDto = new ResponseDto<>("Reserva removido com sucesso!", null);
    return ResponseEntity.ok(responseDto);
  }

}
