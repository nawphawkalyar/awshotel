package com.example.hotelmanagementsystem.service;

import com.example.hotelmanagementsystem.model.Rooms;

import java.util.List;

public interface RoomService {

  Rooms create(Rooms rooms);
  Rooms findById(long id);
  List<Rooms> findAll();
  void delete(long id);
  Rooms update(long id,Rooms rooms);
  Rooms searchRoomsByNumber(String roomNumber);
}
