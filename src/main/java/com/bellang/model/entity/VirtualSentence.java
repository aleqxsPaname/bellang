package com.bellang.model.entity;

import com.bellang.model.enumType.FrontTemplate;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class VirtualSentence {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long ordering;

    @OneToMany
    private List<Version> versions = new ArrayList<>();

    private FrontTemplate template;

    public VirtualSentence(Long ordering, FrontTemplate template){
        this.ordering = ordering;
        this.template = template;
    }

    public void addVersion(Version version){
        versions.add(version);
    }

}
