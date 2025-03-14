package com.prac.hotel_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.hotel_service.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
