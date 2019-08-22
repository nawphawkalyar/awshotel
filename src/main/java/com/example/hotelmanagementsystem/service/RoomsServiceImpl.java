package com.example.hotelmanagementsystem.service;

import com.example.hotelmanagementsystem.model.Rooms;
import com.example.hotelmanagementsystem.repository.RoomsRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class RoomsServiceImpl implements RoomService {

  private final RoomsRepository roomsRepository;

  public RoomsServiceImpl(RoomsRepository roomsRepository) {
    this.roomsRepository = roomsRepository;
  }

  @Override
  public Rooms create(Rooms rooms) {
    return this.roomsRepository.save(rooms);
  }

  @Override
  public Rooms findById(long id) {
    return this.roomsRepository.findById(id).orElse(null);

  }

  @Override
  public List<Rooms> findAll() {
    return this.roomsRepository.findAll();
  }

  @Override
  public void delete(long id) {
      roomsRepository.deleteById(id);
  }
}
