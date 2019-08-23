package com.example.hotelmanagementsystem.exception;

public class RoomNotFoundException extends RuntimeException {

  public RoomNotFoundException(String name){
    super(name);
  }

  public RoomNotFoundException(){

  }
}
