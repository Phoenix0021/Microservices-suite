package com.prac.rating_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac.rating_service.entities.Rating;
import com.prac.rating_service.services.RatingService;

@RestController
@RequestMapping("api/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    //createRating
    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        return ResponseEntity.ok(ratingService.createRating(rating));
    }
    //getAllRating
    @GetMapping("/getAll")
    public ResponseEntity<List<Rating>> getAllRating() {
        return ResponseEntity.ok(ratingService.getAllRating());
    }
    //updateRating
    @PutMapping("/update/{ratingId}")
    public ResponseEntity<Rating> updateRating(@RequestBody Rating rating, String ratingId) {
        return ResponseEntity.ok(ratingService.updateRating(rating, ratingId));
    }
    //deleteRating
    @DeleteMapping("/delete/{ratingId}")
    public ResponseEntity<String> deleteRating(String ratingId) {
        ratingService.deleteRating(ratingId);
        return ResponseEntity.ok("Rating Deleted Successfully");
    }
    //getRatingsByHotelId
    @GetMapping("/getRatingsByHotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(int hotelId) {
        return ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }

    //geRatingsByUserId
    @GetMapping("/getRatingsByUserId/{userId}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId) {
        return ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }



    

}
