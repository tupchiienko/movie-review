package com.cursor.moviereview.service;

import com.cursor.moviereview.dto.ReviewDto;
import com.cursor.moviereview.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface ReviewService {

    Review create(ReviewDto reviewDto);

    void delete(UUID id);

    Review update(UUID id, ReviewDto reviewDto);

    Review findById(UUID id);

    List<Review> findAllByIds(List<UUID> ids);

}
