package com.bellang.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "phrase", schema="bellang")
@Getter
@NoArgsConstructor
public class Phrase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private String langue;

    public Phrase(String content, String language){
        this.content = content;
        this.langue = language;
    }

}
