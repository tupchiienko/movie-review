package com.cursor.moviereview.repository;

import com.cursor.moviereview.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RateRepo extends JpaRepository<Rate, UUID> {
}
