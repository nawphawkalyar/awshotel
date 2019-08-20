package com.example.hotelmanagementsystem.model;

import javax.persistence.*;

@Entity
public class Rooms {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String roomsNumber;
  @Enumerated(EnumType.STRING)
  private RoomType roomType;
  @Enumerated(EnumType.STRING)
  private RoomStatus roomStatus;


  public Rooms() {
  }

  public Rooms(String roomsNumber, RoomType roomType, RoomStatus roomStatus) {
    this.roomsNumber = roomsNumber;
    this.roomType = roomType;
    this.roomStatus = roomStatus;

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRoomsNumber() {
    return roomsNumber;
  }

  public void setRoomsNumber(String roomsNumber) {
    this.roomsNumber = roomsNumber;
  }

  public RoomType getRoomType() {
    return roomType;
  }

  public void setRoomType(RoomType roomType) {
    this.roomType = roomType;
  }

  public RoomStatus getRoomStatus() {
    return roomStatus;
  }

  public void setRoomStatus(RoomStatus roomStatus) {
    this.roomStatus = roomStatus;
  }


}
