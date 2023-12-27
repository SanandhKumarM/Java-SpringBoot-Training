package com.example.SpringBootDataSQL.Services;

import com.example.SpringBootDataSQL.Entity.Course;
import com.example.SpringBootDataSQL.Entity.Learner;
import com.example.SpringBootDataSQL.Repository.LearnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LearnerService {
    @Autowired
    LearnerRepository learnerRepository;


    public Learner assignProfile(int id, Course course){
        Optional<Learner> ap = learnerRepository.findById(id);
        if(ap.isEmpty()){
            throw new RuntimeException("Learner ID"+id+"is not  present");
        }
        Learner learnerCourse = ap.get();
        learnerCourse.setCourse(course);
        return learnerRepository.save(learnerCourse);

    }

    //Get all Courses
    public List<Learner> getAllLearners(){
        return learnerRepository.findAll();
    }

    // Get learner by id
    public Learner getLearnerById(int id){
        return learnerRepository.findById(id).get();
    }

    // Create User
    public Learner createLearner(Learner learner){
        return learnerRepository.save(learner);
    }

    //Remove User
    public void removeLearnerById(int id){
        Optional<Learner> tempUser = learnerRepository.findById(id);
        if(tempUser.isEmpty()){
            throw new RuntimeException("User id" + id + "doesn't exist");
        }
        learnerRepository.deleteById(id);
    }

    //Remove all learners
    public void removeAllLearners(){
        learnerRepository.deleteAll();
    }

    //Check for id
    public boolean checkForLearner(int id) {
        return learnerRepository.existsById(id);
    }
    //Count all the records
    public long numberOfRecords(){
        return learnerRepository.count();
    }
}
