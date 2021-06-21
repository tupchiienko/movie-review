package com.cursor.moviereview.repository;

import com.cursor.moviereview.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ReviewRepo extends JpaRepository<Review, UUID> {
}
