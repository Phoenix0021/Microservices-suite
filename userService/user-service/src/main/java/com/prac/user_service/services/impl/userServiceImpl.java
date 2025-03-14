package com.prac.user_service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.user_service.entity.Hotel;
import com.prac.user_service.entity.Rating;
import com.prac.user_service.entity.User;
import com.prac.user_service.exceptions.ResourceNotFoundException;
import com.prac.user_service.external.services.HotelService;
import com.prac.user_service.external.services.RatingService;
import com.prac.user_service.payload.ApiResponse;
import com.prac.user_service.repositories.UserRepository;
import com.prac.user_service.services.UserService;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RatingService ratingService;

    @Override
    public User saveUser(User user) {
        //gemerate a unique id
        user.setUserId(java.util.UUID.randomUUID().toString());
        return userRepository.save(user);

       
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            List<Rating> ratings = ratingService.getRatingsByUserId(user.getUserId());
            for (Rating rating : ratings) {
                ApiResponse<Hotel> response = hotelService.getHotelById((rating.getHotelId()));
                Hotel hotel = response.getData();
                rating.setHotel(hotel);
            }
            user.setRatings(ratings);
        }
        return users;

    }

    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        List<Rating> ratings = ratingService.getRatingsByUserId(userId);
        for (Rating rating : ratings) {
            ApiResponse<Hotel> response = hotelService.getHotelById((rating.getHotelId()));
            Hotel hotel = response.getData();
            rating.setHotel(hotel);
        }
        user.setRatings(ratings);
        return user;
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
        
    }

    @Override
    public User updateUser(User user, String userId) {
        User userToUpdate = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userToUpdate.setUserId(user.getUserId());
        userToUpdate.setAbout(user.getAbout());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setName(user.getName());
        return userRepository.save(userToUpdate);
    }

    
 

}
