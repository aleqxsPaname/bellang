package com.bellang.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;


    @Size(min = 3, max = 15)
    String name;

    public Category(String name){
        this.name = name;
    }
}
