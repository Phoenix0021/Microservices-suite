package com.prac.user_service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prac.user_service.entity.User;

 
@Service
public interface UserService {
      User saveUser(User user);

      List<User> getAllUsers(); 

      User getUserById(String userId);

      void deleteUser(String userId);

      User updateUser(User user, String userId);


}
