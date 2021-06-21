package com.cursor.moviereview.repository;

import com.cursor.moviereview.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DirectorRepo extends JpaRepository<Director, UUID> {
}
