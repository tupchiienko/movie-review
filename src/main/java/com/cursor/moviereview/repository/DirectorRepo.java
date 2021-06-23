package com.cursor.moviereview.repository;

import com.cursor.moviereview.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DirectorRepo extends JpaRepository<Director, UUID> {
}
