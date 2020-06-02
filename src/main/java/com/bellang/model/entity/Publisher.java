package com.bellang.model.entity;

import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
public class Publisher {

    @Id
    String name;
}
