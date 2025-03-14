package com.prac.user_service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prac.user_service.entity.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

    @GetMapping("/api/rating/getRatingsByUserId/{userId}")
    List<Rating> getRatingsByUserId(@PathVariable String userId);

}
