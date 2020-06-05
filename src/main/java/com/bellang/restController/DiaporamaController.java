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

import java.util.ArrayList;
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

        Diaporama diaporama = new Diaporama();
        diaporama.setName("Titre du diaporama");
        diaporama.setCategory(category);
        diaporama.setPublished(Publish.OFF);

        categoryRepository.save(diaporama.getCategory());

        return  diaporama;
    }


    private List<Slide> generateSampleSlides(){
        List<Slide> slides = new ArrayList<>();

        Slide slide = new Slide();
        slide.setImageReference("Paris_Eiffel_Tower.jpg");
        slide.setOrdering(1L);

        Slide slide2 = new Slide();
        slide2.setImageReference("Paris_Notre_Dame.jpg");
        slide2.setOrdering(2L);

        slides.add(slide);
        slides.add(slide2);

        return slides;
    }

    @GetMapping("/diaporama")
    public Diaporama method(){
        Diaporama diaporama = generateSampleDiaporama();
        diaporamaRepository.save(diaporama);

        List<Slide> slides = generateSampleSlides();

        slides.stream().forEach(s-> s.setDiaporama(diaporama));
        slides.stream().forEach(s-> slideRepository.save(s));

        return diaporama;
    }

}
