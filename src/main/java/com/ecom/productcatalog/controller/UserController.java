package com.ecom.productcatalog.controller;
import org.springframework.web.bind.annotation.*;
import com.ecom.productcatalog.model.User;
import com.ecom.productcatalog.service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173/")
public class UserController {
  private final UserService userService;
  public UserController(UserService userService){
    this.userService=userService;
  }
  @PostMapping(/register)
  public User register(@RequestBody User user){
    return userService.register(user);
  }
  @PostMapping("/login")
  public User login(@RequestBody User user){
    return userService.login(user.getEmail(),user.getPassword());
  }
}
