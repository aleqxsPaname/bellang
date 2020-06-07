package com.bellang.service;

import com.bellang.model.entity.Category;
import com.bellang.model.entity.Diaporama;
import com.bellang.model.entity.Sentence;
import com.bellang.model.entity.Slide;
import com.bellang.model.enumType.FrontTemplate;
import com.bellang.model.enumType.Publish;
import com.bellang.model.repository.CategoryRepository;
import com.bellang.model.repository.DiaporamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FullDiaporamaCreationService {

    @Autowired
    private DiaporamaRepository diaporamaRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public Diaporama generateFullDiaporama(){
        Diaporama diaporama = generateSampleDiaporama();

        List<Slide> slides = generateSampleSlides();

        diaporama.setSlides(slides);
        diaporamaRepository.save(diaporama);
        return diaporama;
    }


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
        slide.setOrdering(2L);
        generateSentenceForThisSlide(slide, "Eiffel Tower");

        Slide slide2 = new Slide();
        slide2.setImageReference("Paris_Notre_Dame.jpg");
        slide2.setOrdering(1L);
        generateSentenceForThisSlide(slide2, "Notre Dame Cathedral");

        slides.add(slide);
        slides.add(slide2);

        return slides;
    }

    private void generateSentenceForThisSlide(Slide slide, String content){
        Sentence sentence = new Sentence("... still today it is the most visited monument in the world", FrontTemplate.BtmLeft);
        Sentence sentence2 = new Sentence(content + " took many years to be build and was a masterpiece of its time", FrontTemplate.TopLeft);
        slide.addSentence(sentence);
        slide.addSentence(sentence2);
    }
}
