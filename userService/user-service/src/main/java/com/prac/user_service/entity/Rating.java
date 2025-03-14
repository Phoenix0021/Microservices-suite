package com.prac.user_service.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private String ratingId;
    private int rating;
    private String userId;
    private int hotelId;
    private String feedback;
    private Hotel hotel;
    
   

    


}
