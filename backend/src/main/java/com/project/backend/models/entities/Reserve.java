package com.project.backend.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * The type Reserve.
 */
@Entity
@Table(name = "reserve")
public class Reserve {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "initial_date")
  private LocalDate initialDate;
  @Column(name = "final_date")
  private LocalDate finalDate;
  private String name;
  private String phone;

  @OneToOne()
  @JoinColumn(name = "vehicle_id")
  @JsonIgnore
  private Vehicle vehicle;

  /**
   * Instantiates a new Reserve.
   */
  public Reserve() {
  }

  /**
   * Instantiates a new Reserve.
   *
   * @param id          the id
   * @param initialDate the initial date
   * @param finalDate   the final date
   * @param name        the name
   * @param phone       the phone
   */
  public Reserve(Long id, LocalDate initialDate, LocalDate finalDate, String name, String phone) {
    this.id = id;
    this.initialDate = initialDate;
    this.finalDate = finalDate;
    this.name = name;
    this.phone = phone;
  }

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets vehicle.
   *
   * @return the vehicle
   */
  public Vehicle getVehicle() {
    return vehicle;
  }

  /**
   * Sets vehicle.
   *
   * @param vehicle the vehicle
   */
  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
  }

  /**
   * Gets inicial date.
   *
   * @return the inicial date
   */
  public LocalDate getInitialDate() {
    return initialDate;
  }

  /**
   * Sets inicial date.
   *
   * @param initialDate the inicial date
   */
  public void setInitialDate(LocalDate initialDate) {
    this.initialDate = initialDate;
  }

  /**
   * Gets final date.
   *
   * @return the final date
   */
  public LocalDate getFinalDate() {
    return finalDate;
  }

  /**
   * Sets final date.
   *
   * @param finalDate the final date
   */
  public void setFinalDate(LocalDate finalDate) {
    this.finalDate = finalDate;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets phone.
   *
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets phone.
   *
   * @param phone the phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }
}
