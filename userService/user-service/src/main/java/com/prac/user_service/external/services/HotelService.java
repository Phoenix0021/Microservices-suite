package com.prac.user_service.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.prac.user_service.entity.Hotel;
import com.prac.user_service.payload.ApiResponse;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {

    @GetMapping("/api/hotel/get/{hotelId}")
    ApiResponse<Hotel> getHotelById(@PathVariable int hotelId);
    
}




