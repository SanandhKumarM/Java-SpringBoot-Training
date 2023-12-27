package com.example.SpringBootDataSQL.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LearnerJDBC {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Learner> getAllLerner(){
        String getAllLearnerQuery = "SELECT * FROM Learner";
        return jdbcTemplate.query(getAllLearnerQuery, new BeanPropertyRowMapper<Learner>(Learner.class));  // new Bean -> trying to row-map to leaner with a type generic of learner
    }
    public int updateLearner(Learner learner){
        String updateLearnerQuery = "Update Learner SET first_name = ?, last_name = ?, email= ?, password = ?, course = ?, "+"  WHERE id = ?";
        return jdbcTemplate.update(updateLearnerQuery, new Object[]{learner.getFirst_name(),learner.getLast_name(), learner.getEmail(),learner.getPassword(),learner.getCourse()});
    }
}
