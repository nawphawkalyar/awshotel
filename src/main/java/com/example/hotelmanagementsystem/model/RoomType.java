package com.example.hotelmanagementsystem.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public enum RoomType {

   Delux("3 persons",200000),
   Luxury("3 persons",300000),
   Economy("3 persons",80000),
   ExtraBed("1 person",30000)
  ;


    RoomType(String name,double price){
      this.name=name;
      this.price=price;
    }
  String name;
  double price;

  public String getName(){
    return  this.name;
  }

  public double getPrice(){
    return this.price;
  }


  }
