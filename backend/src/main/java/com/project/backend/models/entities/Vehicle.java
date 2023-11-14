package com.project.backend.models.entities;

import jakarta.persistence.*;

/**
 * The type Vehicle.
 */
@Entity
@Table(name = "vehicle")
public class Vehicle {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String model;
  private String brand;
  private String color;
  private int manufacturingYear;
  private String licensePlate;
  private boolean reserved = false;


  /**
   * Instantiates a new Vehicle.
   */
  public Vehicle() {
  }

  /**
   * Instantiates a new Vehicle.
   *
   * @param model             the model
   * @param brand             the brand
   * @param color             the color
   * @param manufacturingYear the manufacturing year
   * @param licensePlate      the license plate
   */
  public Vehicle(Long id, String model, String brand, String color, int manufacturingYear, String licensePlate) {
    this.id = id;
    this.model = model;
    this.brand = brand;
    this.color = color;
    this.manufacturingYear = manufacturingYear;
    this.licensePlate = licensePlate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getManufacturingYear() {
    return manufacturingYear;
  }

  public void setManufacturingYear(int manufacturingYear) {
    this.manufacturingYear = manufacturingYear;
  }

  public String getLicensePlate() {
    return licensePlate;
  }

  public void setLicensePlate(String licensePlate) {
    this.licensePlate = licensePlate;
  }

  public boolean isReserved() {
    return reserved;
  }

  public void setReserved(boolean reserved) {
    this.reserved = reserved;
  }
}
