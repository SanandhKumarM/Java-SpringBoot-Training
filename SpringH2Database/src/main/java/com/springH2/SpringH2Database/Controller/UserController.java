package com.springH2.SpringH2Database.Controller;


import com.springH2.SpringH2Database.Entity.User;
import com.springH2.SpringH2Database.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // Meaningful API (Schematic APIs) ->
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    public List<User> getAllUsers(){

        return  userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){

        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public User addUser (@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/del/{id}")
    public void removeUserById(@PathVariable int id){

        userService.removeUserById(id);
    }

    @GetMapping("/delAll")
    public void removeAll(){

        userService.removeAllUsers();
    }
    // Try updating the record

}
