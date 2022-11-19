package com.example.demo.controller;
import com.example.demo.entities.User;
import com.example.demo.service.UserService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
//@ResponseBody: Used to bind the HTTP response body with a domain object in the return type.
import java.util.Map;



@SpringBootApplication
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/users")
    public Map getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id){
        return (User) userService.getUser(id);
    }

    @PostMapping("/user/register")
    public String[] registerUser(@RequestParam(value = "name", defaultValue = "user") String name,
                           @RequestParam(value="phone") String phone,
                           @RequestParam(value="email") String email) {
        User regUser=userService.registerUser(name, phone,email);
        return regUser.getValue();
    }


}
