package com.springH2.SpringH2Database.Service;

import com.springH2.SpringH2Database.Entity.User;
import com.springH2.SpringH2Database.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // Get All Users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    // Get User by Id
    public User getUserById(@PathVariable("user_id") int id){
        return userRepository.findById(id).get();
    }

    // Create User
    public User createUser(User user){
        return userRepository.save(user);
    }

    //Remove User
    public void removeUserById(int id){
        Optional<User> tempUser = userRepository.findById(id);
        if(tempUser.isEmpty()){
            throw new RuntimeException("User id" + id + "doesn't exist");
        }
        userRepository.deleteById(id);
    }

    public void removeAllUsers(){
        userRepository.deleteAll();
    }

    //Number of records
    public long numberOfRecords(){
        return userRepository.count();
    }
}
