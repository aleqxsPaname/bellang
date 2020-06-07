package com.bellang.model.entity;

import com.bellang.model.enumType.Publish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Diaporama implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Publish published;

    @ManyToOne
    Category category;

    String name;

    @OneToMany(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "diaporama_id")
    List<Slide> slides = new ArrayList<>();

    public void addSlide(Slide slide){
        slides.add(slide);
    }

}
