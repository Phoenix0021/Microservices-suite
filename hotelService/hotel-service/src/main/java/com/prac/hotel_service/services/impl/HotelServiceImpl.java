package com.prac.hotel_service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.hotel_service.entities.Hotel;
import com.prac.hotel_service.exceptions.ResourceNotFoundException;
import com.prac.hotel_service.repositories.HotelRepository;
import com.prac.hotel_service.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepo;

    @Override
    public Hotel createHotel(Hotel hotel) {
        return  hotelRepo.save(hotel);
       
    }

    @Override
    public Hotel getHotelById(int id) {
        return hotelRepo.findById(id).orElseThrow();
    }

    @Override
    public Hotel updateHotel(int id, Hotel hotel) {
        Hotel hotelToUpdate = hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found"+id));
        hotelToUpdate.setName(hotel.getName());
        hotelToUpdate.setLocation(hotel.getLocation());
        hotelToUpdate.setAbout(hotel.getAbout());
        return hotelRepo.save(hotelToUpdate);
    }

    @Override
    public void deleteHotel(int id) {
        hotelRepo.deleteById(id);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    
    


}
