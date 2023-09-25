package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}