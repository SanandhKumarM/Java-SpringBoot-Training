package com.springH2.SpringH2Database.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springH2.SpringH2Database.Entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
