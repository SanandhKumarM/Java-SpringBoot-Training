package com.example.signupservice.Service;

import com.example.signupservice.Model.User;
import com.example.signupservice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String signup(User user){

        User savedUser = userRepository.save(user);

        return "{"+
                "\"message\":"+"\"Sucessfully Created User\",\n"+"\"data\":"+savedUser+",\n"+"}";
    }


    public String login(String email, String password){
        List<User> foundUser = userRepository.getUserByEmail(email);

        if(foundUser.isEmpty()){
            return "{"+
                    "\"message\":"+"\"Sucessfully Created User\",\n"+"}";
        }
        else if(!foundUser.get(0).getPassword().equals(password)){
            return "{"+
                    "\"message\":"+"\"Password Incorrect\",\n"+"}";
        }
        return "{"+
                "\"message\":"+"\"Sucessfully Logged In\",\n"+"\"data\":"+foundUser.get(0).getName()+",\n"+"Email :"+foundUser.get(0).getEmail()+",\n"+"}";
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
