package com.spring.secure.controller;

import com.spring.secure.model.User;
import com.spring.secure.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.aggregation.VariableOperators;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

     private final UserService userService;

    UserController(UserService userService)
    {
        this.userService = userService;
    }

    @PostMapping("/add-user")
    public String signUp(@RequestBody User user)
    {
        return userService.signUp(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody Map<String,Object> map)
    {
        return userService.login(map.get("email").toString(), map.get("password").toString());
    }

    @GetMapping("/get-user")
    public User getUser(HttpServletRequest request)
    {
        ObjectId userId = (ObjectId) request.getAttribute("userId");
        return userService.getUser(userId);

    }
}
