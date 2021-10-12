package com.cursor.moviereview.service.impl;

import com.cursor.moviereview.dto.ReviewDto;
import com.cursor.moviereview.entity.Review;
import com.cursor.moviereview.repository.ReviewRepo;
import com.cursor.moviereview.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;
    private final ModelMapper modelMapper;

    @Override
    public Review create(ReviewDto reviewDto) {
        var review = new Review();
        modelMapper.map(reviewDto, review);
        review = reviewRepo.save(review);
        return review;
    }

    @Override
    public void delete(UUID id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public Review update(UUID id, ReviewDto reviewDto) {
        var review = reviewRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        modelMapper.map(reviewDto, review);
        review = reviewRepo.save(review);
        return review;
    }

    @Override
    public Review findById(UUID id) {
        return reviewRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Review> findAllByIds(List<UUID> ids) {
        return reviewRepo.findAllById(ids);
    }
}
