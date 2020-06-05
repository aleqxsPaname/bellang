package com.bellang.restController;

import com.bellang.model.entity.Category;
import com.bellang.model.entity.Diaporama;
import com.bellang.model.entity.Slide;
import com.bellang.model.enumType.Publish;
import com.bellang.model.repository.CategoryRepository;
import com.bellang.model.repository.DiaporamaRepository;

import com.bellang.model.repository.SlideRepository;
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

    @Autowired
    private SlideRepository slideRepository;


    private Diaporama generateSampleDiaporama() {


        Category category = categoryRepository.findByName("VILLE").orElse(new Category("VILLE"));

        Slide slide = new Slide();
        slide.setImageReference("Paris_Eiffel_Tower.jpg");
        slide.setOrdering(1L);

        Slide slide2 = new Slide();
        slide2.setImageReference("Paris_Eiffel_Tower.jpg");
        slide2.setOrdering(2L);

        Diaporama diaporama = new Diaporama();
        diaporama.setName("Titre du diaporama");
        diaporama.setCategory(category);
        diaporama.setPublished(Publish.OFF);
        diaporama.addSlide(slide);
        diaporama.addSlide(slide2);

        return  diaporama;
    }


    @GetMapping("/diaporama")
    public Diaporama method(){
        Diaporama diaporama = generateSampleDiaporama();
        categoryRepository.save(diaporama.getCategory());
        diaporama.getSlides().stream().forEach(s-> slideRepository.save(s));
        diaporamaRepository.save(diaporama);
        return diaporama;
    }

}
