package com.bellang.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "phrase", schema="bellang")
public class Phrase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private String langue;

    public Phrase(String content, String langue){
        this.content = content;
        this.langue = langue;
    }

    public Phrase(){ };

    public String getContent(){
        return this.content;
    }

}
