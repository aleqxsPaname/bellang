package com.bellang.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Slide {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long ordering;

    String imageReference;

/*
    @ManyToOne
    Diaporama diaporama;
*/


}
