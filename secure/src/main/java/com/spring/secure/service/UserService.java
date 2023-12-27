package com.spring.secure.service;

import com.spring.secure.model.User;
import com.spring.secure.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private TokenService tokenService;


    UserService(UserRepository userRepository, TokenService tokenService)
    {
        this.userRepository = userRepository;
        this.tokenService = tokenService;
    }


    public User getUser(ObjectId id)
    {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.orElseGet(optionalUser::get);
    }

    public List<User> getUser(){
       return userRepository.findAll();
    }

    public String signUp(User user){
        User savedUser = userRepository.save(user);
        return String.format( "{\n\t \"Message\": \"Successfully Create the user\",\n\t \"data\": %s \n}", user.toString());
    }


    public String login(String email, String password)
    {
        List<User> foundUsers = userRepository.getUserByEmail(email);
        if (foundUsers.isEmpty())
        {
            return "Authentication failed";
        }
        else if(!foundUsers.get(0).getPassword().equals(password))
        {
            return "Incorrect Password";
        }

        String token = tokenService.createToken(foundUsers.get(0).getId());

        return String.format("{\12\t\"message\": \"Successfully logged in\",\12\t" +
                "\"data\":{\"Name\": \"%s\", \n\t\t \"Email\": \"%s\" },\12\t\"token\": \"%s\" \n }", foundUsers.get(0).getName(),
                foundUsers.get(0).getEmail(),token);
    }
}
