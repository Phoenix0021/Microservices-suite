package com.prac.user_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.user_service.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
