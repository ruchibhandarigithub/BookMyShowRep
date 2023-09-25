package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeats,Integer> {
}