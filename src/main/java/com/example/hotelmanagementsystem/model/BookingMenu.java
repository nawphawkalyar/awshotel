package com.example.hotelmanagementsystem.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class BookingMenu {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ElementCollection
  private List<String> reserveList=new ArrayList<>();
  @ElementCollection
  private List<String> freeReserveList=new ArrayList<>();
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate dailyReserve;

  @ManyToOne
  private Rooms rooms;
  @ManyToOne
  private Promotions promotions;
  @ManyToOne
  private Bookings bookings;


  public BookingMenu() {
  }

  public BookingMenu(LocalDate dailyReserve) {
    this.dailyReserve = dailyReserve;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public List<String> getReserveList() {
    return reserveList;
  }

  public void setReserveList(List<String> reserveList) {
    this.reserveList = reserveList;
  }

  public List<String> getFreeReserveList() {
    return freeReserveList;
  }

  public void setFreeReserveList(List<String> freeReserveList) {
    this.freeReserveList = freeReserveList;
  }

  public LocalDate getDailyReserve() {
    return dailyReserve;
  }

  public void setDailyReserve(LocalDate dailyReserve) {
    this.dailyReserve = dailyReserve;
  }


  public Rooms getRooms() {
    return rooms;
  }

  public void setRooms(Rooms rooms) {
    this.rooms = rooms;
  }

  public Promotions getPromotions() {
    return promotions;
  }

  public void setPromotions(Promotions promotions) {
    this.promotions = promotions;
  }

  public Bookings getBookings() {
    return bookings;
  }

  public void setBookings(Bookings bookings) {
    this.bookings = bookings;
  }
}

