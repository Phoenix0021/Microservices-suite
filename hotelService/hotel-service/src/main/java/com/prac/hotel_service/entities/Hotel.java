package com.prac.hotel_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="hotels")
public class Hotel {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int hotelId;
        private String name;
        private String location;
        private String about;

}
