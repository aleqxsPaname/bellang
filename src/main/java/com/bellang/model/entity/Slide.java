package com.bellang.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Slide {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int ordering;

    private String imageReference;

   /* @ManyToOne
    Diaporama diaporama;*/

    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "slide_id")
    @OrderBy("template DESC")
    private List<Sentence> sentences = new ArrayList<>();

    public void addSentence(Sentence sentence){
        this.sentences.add(sentence);
        // we would add business rule to make sure FrontTemplate are always different
    }

}
