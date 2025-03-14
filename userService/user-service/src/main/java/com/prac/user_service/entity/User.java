package com.prac.user_service.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "micro_users")
@Getter
@Setter
public class User {
    
    @Id
    @Column(name = "user_id")
    private String userId;
    private String name;
    private String email;
    private String about;
    
    @Transient
    private List<Rating> ratings; 


}
