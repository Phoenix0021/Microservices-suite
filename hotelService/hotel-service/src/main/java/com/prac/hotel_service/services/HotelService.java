package com.prac.hotel_service.services;

import com.prac.hotel_service.entities.Hotel;
import java.util.List;

public interface HotelService {


    Hotel createHotel(Hotel hotel);

    Hotel getHotelById(int id);

    Hotel updateHotel(int id, Hotel hotel);

    void deleteHotel(int id);

    List<Hotel> getAllHotels();

}
