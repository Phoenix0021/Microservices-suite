package com.prac.hotel_service.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prac.hotel_service.entities.Hotel;
import com.prac.hotel_service.payload.ApiResponse;
import com.prac.hotel_service.services.HotelService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = hotelService.createHotel(hotel);
        ApiResponse response = ApiResponse.builder()
                .message("Hotel created successfully")
                .success(true)
                .status(HttpStatus.CREATED)
                .data(createdHotel)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/get/{hotelId}")
    public ResponseEntity<ApiResponse> getHotelById(@PathVariable int hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        ApiResponse response = ApiResponse.builder()
                .message("Hotel fetched successfully")
                .success(true)
                .status(HttpStatus.OK)
                .data(hotel)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/update/{hotelId}")
    public ResponseEntity<ApiResponse> updateHotel(@PathVariable int hotelId, @RequestBody Hotel hotel) {
        Hotel updatedHotel = hotelService.updateHotel(hotelId, hotel);
        ApiResponse response = ApiResponse.builder()
                .message("Hotel updated successfully")
                .success(true)
                .status(HttpStatus.OK)
                .data(updatedHotel)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<ApiResponse> deleteHotel(@PathVariable int hotelId) {
        hotelService.deleteHotel(hotelId);
        ApiResponse response = ApiResponse.builder()
                .message("Hotel deleted successfully")
                .success(true)
                .status(HttpStatus.OK)
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

}
