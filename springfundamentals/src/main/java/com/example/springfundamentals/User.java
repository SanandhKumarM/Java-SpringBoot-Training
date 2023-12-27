package com.example.springfundamentals;


import javax.persistence.*;

@Entity // Representing  class or interface
@Table(name = "users")
public class User {
    public User(String fname, String lname) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="fname")
    private String fname;

    @Column(name="lname")
    private String lname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }



    public void setLname(String lname) {
        this.lname = lname;
    }


    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }


}