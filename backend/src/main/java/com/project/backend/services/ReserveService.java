package com.project.backend.services;

import com.project.backend.models.entities.Reserve;
import com.project.backend.models.entities.Vehicle;
import com.project.backend.models.repositories.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReserveService {
  private final ReserveRepository reserveRepository;

  @Autowired
  public ReserveService(ReserveRepository reserveRepository) {
    this.reserveRepository = reserveRepository;
  }

  public List<Reserve> getAll() {
    return reserveRepository.findAll();
  }

//  public Optional<Reserve> removeById(Long id) {
//    Optional<Reserve> reserveOptional = reserveRepository.findById(id);
//
//    if (reserveOptional.isPresent()) {
//      reserveRepository.deleteById(id);
//    }
//
//    return reserveOptional;
//  }
}
