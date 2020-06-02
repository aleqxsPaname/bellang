package com.bellang.restController;

import com.bellang.model.entity.Category;
import com.bellang.model.entity.Diaporama;
import com.bellang.model.entity.Publisher;
import com.bellang.model.enumType.Publish;
import com.bellang.model.repository.CategoryRepository;
import com.bellang.model.repository.DiaporamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
public class DiaporamaController {


    @Autowired
    private DiaporamaRepository diaporamaRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    private Diaporama generateSampleDiaporama() {
        Long i = 1L;
        Category category = new Category();
        category.setName("VILLE");
        Publisher publisher = new Publisher("Alexis");
        Diaporama diaporama = new Diaporama();
        diaporama.setName("Titre du diaporama");
        diaporama.setCategory(category);
        diaporama.setPublished(Publish.OFF);
      //  Diaporama diaporama = new Diaporama(i,Publish.ON,category, publisher, "titre");
        return  diaporama;
    }


    @GetMapping("/diaporama")
    public Diaporama method(){
        Diaporama diaporama = generateSampleDiaporama();
        categoryRepository.save(diaporama.getCategory());
        diaporamaRepository.save(diaporama);
        return diaporama;
    }

}
