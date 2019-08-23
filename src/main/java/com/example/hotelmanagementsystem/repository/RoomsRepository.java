package com.example.hotelmanagementsystem.repository;

import com.example.hotelmanagementsystem.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms,Long> {

  Rooms findByRoomsNumber(String roomNumber);

}
