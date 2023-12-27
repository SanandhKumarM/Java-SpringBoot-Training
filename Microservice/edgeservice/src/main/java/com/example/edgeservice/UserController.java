package com.example.edgeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient
public class UserController {

    private final UserClient userClient;

    @Autowired
    public UserController(UserClient userClient){
        this.userClient = userClient;
    }


}
