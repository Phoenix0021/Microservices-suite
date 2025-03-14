package com.prac.rating_service.services;

import java.util.List;

import com.prac.rating_service.entities.Rating;

public interface RatingService {
    //createRating
    Rating createRating(Rating rating);

    //getAllRating
    List<Rating> getAllRating();

    //updateRating
    Rating updateRating(Rating rating, String ratingId);

    //deleteRating
    void deleteRating(String ratingId);

    //getRatingsByHotelId
    List<Rating> getRatingsByHotelId(int hotelId);

    //getRatingsByUserId
    List<Rating> getRatingsByUserId(String userId);

}
