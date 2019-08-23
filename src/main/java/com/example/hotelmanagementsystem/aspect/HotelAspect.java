package com.example.hotelmanagementsystem.aspect;

import com.example.hotelmanagementsystem.exception.RoomNotFoundException;
import com.example.hotelmanagementsystem.model.Rooms;
import com.example.hotelmanagementsystem.repository.RoomsRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Aspect
@Component
public class HotelAspect {

  private Logger logger=LoggerFactory.getLogger(this.getClass());


  private final RoomsRepository roomsRepository;

  public HotelAspect( RoomsRepository roomsRepository) {


    this.roomsRepository=roomsRepository;
  }

  @Before("execution(* *.processRooms(..))")
  public void roomNumberAspect(JoinPoint joinPoint){
      Object[] args=joinPoint.getArgs();
      boolean roomNumberSame=false;
      Rooms room=(Rooms)args[0];

      logger.info("Room Number:"+ room.getRoomsNumber());

     for(Rooms rooms: roomsRepository.findAll()){
          if(rooms.getRoomsNumber().equals(room.getRoomsNumber())){
            roomNumberSame=true;
          }
      }

      if(roomNumberSame){
        throw new IllegalArgumentException(room.getRoomsNumber()
                +"Rooms are already existed.");
      }





  }

  @Before("execution(* *.showRoomDetails(..))")
  public void roomNotFoundAspect(JoinPoint joinPoint){
    Object[] args=joinPoint.getArgs();
    Rooms rooms= roomsRepository.findById((long)args[1])
            .orElseThrow(()-> new EntityNotFoundException((long)args[1]+ " Not Found Entity!"));

  }

  @Before("execution(* *.searchRoomsByNumber(..))")
  public void roomNotFoundFindAspect(JoinPoint joinPoint){
    Object[] arg=joinPoint.getArgs();

    logger.info( arg[0]+ " Room Number");
    roomsRepository.findByRoomsNumber(String.valueOf(arg[0]))
            .orElseThrow(()-> new RoomNotFoundException(arg[0] + " Not Found."));

  }
}
