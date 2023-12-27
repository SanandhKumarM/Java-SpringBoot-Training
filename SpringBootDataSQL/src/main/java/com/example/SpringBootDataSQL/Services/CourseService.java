package com.example.SpringBootDataSQL.Services;

import com.example.SpringBootDataSQL.Entity.Course;
import com.example.SpringBootDataSQL.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    //Get all Courses
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    // Get learner by id
    public Course getCourseById(int id){
        return courseRepository.findById(id).get();
    }

    // Create User
    public Course createCourses(Course course){
        return courseRepository.save(course);
    }

    //Remove User
    public void removeCoursesById(int id){
        Optional<Course> tempUser = courseRepository.findById(id);
        if(tempUser.isEmpty()){
            throw new RuntimeException("User id" + id + "doesn't exist");
        }
        courseRepository.deleteById(id);
    }

    //Remove all learners
    public void removeAllCourses(){
        courseRepository.deleteAll();
    }

    //Check for id
    public boolean checkForCourse(int id) {
        return courseRepository.existsById(id);
    }
    //Count all the records
    public long numberOfRecords(){
        return courseRepository.count();
    }

}
