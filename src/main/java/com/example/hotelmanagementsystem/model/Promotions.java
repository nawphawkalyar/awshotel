package com.example.hotelmanagementsystem.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Promotions {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String seasonal;

  private String packageProMotion;
  //percent
  private double discount;

  private String service;

  public Promotions() {
  }

  public Promotions(String seasonal, String packageProMotion, double discount, String service) {
    this.seasonal = seasonal;
    this.packageProMotion = packageProMotion;
    this.discount = discount;
    this.service = service;
  }


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSeasonal() {
    return seasonal;
  }

  public void setSeasonal(String seasonal) {
    this.seasonal = seasonal;
  }

  public String getPackageProMotion() {
    return packageProMotion;
  }

  public void setPackageProMotion(String packageProMotion) {
    this.packageProMotion = packageProMotion;
  }

  public double getDiscount() {
    return discount;
  }

  public void setDiscount(double discount) {
    this.discount = discount;
  }

  public String getService() {
    return service;
  }

  public void setService(String service) {
    this.service = service;
  }
}
