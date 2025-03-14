package com.prac.hotel_service.payload;

import org.springframework.http.HttpStatus;

import com.prac.hotel_service.entities.Hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private Boolean success;
    private HttpStatus status;
    private Hotel data;

}
