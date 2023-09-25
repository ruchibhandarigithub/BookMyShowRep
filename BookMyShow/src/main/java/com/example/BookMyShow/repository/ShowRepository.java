package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}