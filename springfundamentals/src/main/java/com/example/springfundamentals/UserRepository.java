package com.example.springfundamentals;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

// interface because of multiple inheritance
@Repository
public interface UserRepository extends JpaRepository<User,Integer>, CrudRepository<User,Integer>{     // For single interface, but we used interface , this repository is going to communicate with databases
    // <> is called type generics, we're saying to JpaRep that these are the only databases I want
}
