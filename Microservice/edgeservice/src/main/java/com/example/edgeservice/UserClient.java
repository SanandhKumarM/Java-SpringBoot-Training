package com.example.edgeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient("signup-client")
public interface UserClient {

    @GetMapping("user")
    Collection<User> readUser();
}
