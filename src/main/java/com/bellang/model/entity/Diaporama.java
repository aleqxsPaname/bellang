package com.bellang.model.entity;

import com.bellang.model.enumType.Publish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

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

  /*  @ManyToOne
    Publisher publisher;*/

    String name;


}
