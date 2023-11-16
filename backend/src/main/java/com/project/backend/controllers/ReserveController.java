package com.project.backend.controllers;

import com.project.backend.controllers.dto.ReserveDto;
import com.project.backend.controllers.dto.ResponseDto;
import com.project.backend.controllers.dto.VehicleDto;
import com.project.backend.models.entities.Reserve;
import com.project.backend.models.entities.Vehicle;
import com.project.backend.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/reserve")
public class ReserveController {
  private ReserveService reserveService;

  @Autowired
  public ReserveController(ReserveService reserveService) {
    this.reserveService = reserveService;
  }


  @GetMapping()
  public List<ReserveDto> getAll() {
    List<Reserve> allReserves = reserveService.getAll();
    return allReserves.stream()
      .map((reserve) -> new ReserveDto(reserve.getId(), reserve.getInitialDate(), reserve.getFinalDate(), reserve.getName(), reserve.getPhone()))
      .collect(Collectors.toList());
  }

//  @DeleteMapping("/{reserveId}")
//  public ResponseEntity<ResponseDto<Vehicle>> removeById(@PathVariable Long reserveId) {
//    Optional<Reserve> optionalReserve = reserveService.removeById(reserveId);
//
//    if (optionalReserve.isEmpty()) {
//      ResponseDto<Vehicle> responseDto = new ResponseDto<>(
//        String.format("Não foi possível deletar a reserva de ID %d", reserveId), null);
//      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto);
//    }
//
//    ResponseDto<Vehicle> responseDto = new ResponseDto<>("Reserva removido com sucesso!", null);
//    return ResponseEntity.ok(responseDto);
//  }
}
