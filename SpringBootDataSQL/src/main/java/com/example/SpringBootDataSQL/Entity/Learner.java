package com.example.SpringBootDataSQL.Entity;


import javax.persistence.*;

@Entity
@Table(name = "learners")
public class Learner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int learner_id;

    private String first_name;
    private String last_name;
    private String email;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id_ref", referencedColumnName = "course_id")
    private Course course;

    // Getters and Setters
    public int getLearner_id() {
        return learner_id;
    }

    public void setLearner_id(int learner_id) {
        this.learner_id = learner_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    // Default constructors
    public Learner() {
    }

    // Constructors
    public Learner(int learner_id, String first_name, String last_name, String email, String password, Course course) {
        this.learner_id = learner_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.course = course;
    }

    // toString()
    @Override
    public String toString() {
        return "Learner{" +
                "learner_id=" + learner_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", course=" + course +
                '}';
    }
}
