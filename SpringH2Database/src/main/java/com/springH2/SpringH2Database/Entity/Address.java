package com.springH2.SpringH2Database.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor  // Default Constructor
@Entity
@Table
public class Address implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String address;
    private String city;
    private String country;
    private long pincode;


}
