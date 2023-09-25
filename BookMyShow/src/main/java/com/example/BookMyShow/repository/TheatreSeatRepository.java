package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.TheatreSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface TheatreSeatRepository extends JpaRepository<TheatreSeat,Integer> {
}