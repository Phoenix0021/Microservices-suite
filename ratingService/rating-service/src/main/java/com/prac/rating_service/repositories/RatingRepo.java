package com.prac.rating_service.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prac.rating_service.entities.Rating;

public interface RatingRepo extends MongoRepository<Rating, String> {

}
