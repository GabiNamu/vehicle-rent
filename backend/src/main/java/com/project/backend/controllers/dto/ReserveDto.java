package com.project.backend.controllers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.backend.models.entities.Reserve;
import java.time.LocalDate;

/**
 * The type Reserve dto.
 */
public record ReserveDto(
    Long id,
    @JsonProperty("initial_date")
    LocalDate initialDate,
    @JsonProperty("final_date")
    LocalDate finalDate,
    String name,
    String phone
) {
  /**
   * To reserve.
   *
   * @return the reserve
   */
  public Reserve toReserve() {
    return new Reserve(id, initialDate, finalDate, name, phone);
  }
}
