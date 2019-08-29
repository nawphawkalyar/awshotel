package com.example.hotelmanagementsystem.controller;

import com.example.hotelmanagementsystem.service.RoomService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


  private final RoomService roomService;

  public ViewController(RoomService roomService) {
    this.roomService = roomService;
  }

  @GetMapping("/view/rooms")
  public String viewAllRooms(Model model){
    model.addAttribute("rooms",roomService.findAll());
    return "views/rooms";
  }
}
