package com.example.hotelmanagementsystem.repository;

import com.example.hotelmanagementsystem.model.BookingMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingMenuRepository extends JpaRepository<BookingMenu,Long> {
}
