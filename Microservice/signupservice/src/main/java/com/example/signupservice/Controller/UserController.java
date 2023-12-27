package com.example.signupservice.Controller;

import com.example.signupservice.Model.User;
import com.example.signupservice.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add-user")
    public String signup(@RequestBody User user){
        return userService.signup(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String, Object> map){
        return userService.login(map.get("email").toString(),map.get("password").toString());
    }

    @GetMapping("/get-users")
    public List<User> getUser(){
        return userService.getUsers();
    }
}
