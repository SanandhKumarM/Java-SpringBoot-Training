package com.spring.secure.repository;

import com.spring.secure.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

    @Query("{email: \"?0\"}")
    List<User> getUserByEmail(String email);
}
