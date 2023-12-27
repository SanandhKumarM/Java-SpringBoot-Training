package com.springH2.SpringH2Database.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor  // Default Constructor
@Entity
@Table
public class Mobile {

    @Id
    @GeneratedValue
    private int id;

    private long number;

}
