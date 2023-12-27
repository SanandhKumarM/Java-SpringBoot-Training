package com.spring.secure.repository;

import org.bson.types.ObjectId;
import com.spring.secure.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {


}
