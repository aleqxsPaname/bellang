package com.bellang.model.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
public class Version {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn( name="virtualSentence_Id", nullable=false )
    private final VirtualSentence virtualSentence;

    private final String language;

    @Getter
    private String content;

    private int note = 0;

    private boolean isBest = true;

    public Version(VirtualSentence virtualSentence, String language, String content){
        this.virtualSentence = virtualSentence;
        this.language = language;
        this.content = content;
    }
}
