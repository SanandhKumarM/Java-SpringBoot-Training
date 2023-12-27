package com.example.SpringBootDataSQL.Repository;

import com.example.SpringBootDataSQL.Entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnerRepository extends JpaRepository<Learner, Integer> {
    @Modifying
    @Query("SELECT 1 FROM Learner l WHERE l.email= :email AND l.last_Name = :lastName")
    List<Learner> findByEmailAddressAndLastName(@Param("email") String email,@Param("lastName")  String lastName);

    @Modifying
    @Query("SELECT DISTINCT FROM Learner l WHERE l.first_name = :firstName OR l.last_name = :lastName")
    List<Learner> findDistinctLearnerByLastNameOrFirstName(@Param("firstName") String firstName, @Param("lastName") String last);

    @Modifying
    @Query("SELECT 1 FROM Learner l WHERE UPPER(l.last_name)= UPPER(:lastName)")
    List<Learner> findByLastNameIgnoreCase(@Param("lastName") String lastName);


    @Modifying
    @Query("SELECT 1 FROM Learner l WHERE l.last_name = lastName ORDER BY l.first_name")
    List<Learner> findLastNameOrderByFirstNameAsc(@Param("lastName") String lastName);
}
