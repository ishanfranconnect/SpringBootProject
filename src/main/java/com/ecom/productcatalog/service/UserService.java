package com.ecom.productcatalog.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ecom.productcatalog.model.User;
import com.ecom.productcatalog.repository.UserRepository;

@Service
public class UserService {

   public final UserRespository userRepository;
  public UserService(UserRespository userRepository){
    this.userRepository=userRepository;
  }
  // for register
  public User register(User user){
    Optinal<User>existing=userRepository.findByEmail(user.getEmail());
    if(existing.isPresent()){
      throw new RuntimeException("Email already exists);
    }
    return userRepository.save(user);
  }

  // for login
  public User login(String email,String password){
    User user=userRepository.findByEmail(email).orElseThrow(()->new RuntimeException("User not found"));
    if(!user.getPassword().equals(password)){
      throw new RuntimeException("Invalid Password");
    }
    return user;
  }
  
  
}
