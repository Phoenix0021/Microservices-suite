package com.prac.rating_service.services.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.rating_service.entities.Rating;
import com.prac.rating_service.repositories.RatingRepo;
import com.prac.rating_service.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating createRating(Rating rating) {
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepo.findAll();
    }

    @Override
    public Rating updateRating(Rating rating, String ratingId) {
        Rating existingRating = ratingRepo.findById(ratingId).orElse(null);
        existingRating.setFeedback(rating.getFeedback());
        existingRating.setRating(rating.getRating());
        return ratingRepo.save(existingRating);
    }

    @Override
    public void deleteRating(String ratingId) {
        ratingRepo.deleteById(ratingId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(int hotelId) {
        return ratingRepo.findAll().stream().filter(rating -> rating.getHotelId() == hotelId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepo.findAll().stream().filter(rating -> rating.getUserId().equals(userId))
                .collect(Collectors.toList());
    }

}
