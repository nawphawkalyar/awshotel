package com.example.hotelmanagementsystem.controller;

import com.example.hotelmanagementsystem.model.Bookings;
import com.example.hotelmanagementsystem.model.RoomStatus;
import com.example.hotelmanagementsystem.model.Rooms;
import com.example.hotelmanagementsystem.model.UserProfile;
import com.example.hotelmanagementsystem.service.BookingsService;
import com.example.hotelmanagementsystem.service.RoomService;
import com.example.hotelmanagementsystem.service.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Random;

@Controller
public class ViewController {


  private final RoomService roomService;
  private final UserDetailsServiceImpl userDetailsService;
  private final BookingsService bookingsService;

  public ViewController(RoomService roomService, UserDetailsServiceImpl userDetailsService
          , BookingsService bookingsService) {
    this.roomService = roomService;
    this.userDetailsService = userDetailsService;
    this.bookingsService = bookingsService;
  }

  @GetMapping("/view/rooms")
  public String viewAllRooms(Model model){
    model.addAttribute("rooms",roomService.findAll());
    return "views/rooms";
  }
  @GetMapping("/view/rooms/{id}")
  public String viewRoomDetails(Model model,@PathVariable("id")Long id){
    model.addAttribute("room",roomService.findById(id));
    this.roomId=id;
    return "views/room";
  }
  @GetMapping("/view/userprofile/{id}")
  public String userProfileCreate(Model model,@PathVariable("id")Long roomid){
    model.addAttribute("userprofile",new UserProfile());
    return "views/profile";
  }
  @PostMapping("/view/userprofile")
  public String userProfileProcess(UserProfile userProfile){
    UserProfile userProfile11=this.userDetailsService.register(userProfile);
    this.userProfileId=userProfile11.getId();

    return "redirect:/view/booking";

  }
  @GetMapping("/view/booking")
  public String bookingCreate(Model model){
    model.addAttribute("booking",new Bookings());
    return "views/bookingForm";
  }
  @PostMapping("/view/booking")
  @Transactional
  public String bookingProcess(Bookings bookings, RedirectAttributes redirectAttributes){
    if(bookings.isBookingCancelled()){
      return "redirect:/home";
    }

    bookings.setUserProfile(this.userDetailsService.findById(userProfileId));
    String bookingNum="Delux"+(++bookingNumber)+new Random().nextInt(1000);
    bookings.setBookingNumber(bookingNum);

    Rooms rooms=roomService.findById(roomId);
    double roomPrice=rooms.getRoomType().getPrice();
    double balance=(roomPrice-bookings.getInAdvance());
    bookings.setFullCharges(balance);
    bookings.setBookingCancelled(false);

    bookingsService.create(bookings);
    redirectAttributes.addFlashAttribute("booking",true);
    redirectAttributes.addFlashAttribute("bookingNumber",bookingNum);

    rooms.setRoomStatus(RoomStatus.Reverse);
    return "redirect:/home";
  }




  private Long userProfileId;
  private Long roomId;
  private static int bookingNumber=111;
}
