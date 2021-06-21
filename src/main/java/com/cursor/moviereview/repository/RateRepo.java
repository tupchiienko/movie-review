package com.cursor.moviereview.repository;

import com.cursor.moviereview.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RateRepo extends JpaRepository<Rate, UUID> {
}
