package com.bellang.model.entity;

import com.bellang.model.enumType.FrontTemplate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Sentence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String content;

    private FrontTemplate template;

/*    @ManyToOne
    private Slide slide;*/

    public Sentence(String content, FrontTemplate template){
        this.content = content;
        this.template = template;
    //    this.slide = slide;
    }

}
