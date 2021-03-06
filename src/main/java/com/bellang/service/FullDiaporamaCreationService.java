package com.bellang.service;

import com.bellang.model.entity.Category;
import com.bellang.model.entity.Diaporama;
import com.bellang.model.entity.VirtualSentence;
import com.bellang.model.entity.Slide;
import com.bellang.model.enumType.FrontTemplate;
import com.bellang.model.enumType.Publish;
import com.bellang.model.repository.CategoryRepository;
import com.bellang.model.repository.DiaporamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class FullDiaporamaCreationService {

    @Autowired
    private DiaporamaRepository diaporamaRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Diaporama> generateFullDiaporama(){

        createAndSaveInDB();
        return retrieve();


    }

    @Transactional
    private void createAndSaveInDB(){
        Diaporama diaporama = generateSampleDiaporama();
        List<Slide> slides = generateSampleSlides();

        diaporama.setSlides(slides);
        diaporamaRepository.save(diaporama);

    }

    @Transactional
    private List<Diaporama>  retrieve(){
        List<Diaporama> diaporamas = diaporamaRepository.findAll();
        diaporamas.get(0).getSlides().forEach(slide -> System.out.println(slide.getOrdering()));
        return diaporamaRepository.findAll();

    }

    private Diaporama generateSampleDiaporama() {

        Category category = categoryRepository.findByName("VILLE").orElse(new Category("VILLE"));

        Diaporama diaporama = new Diaporama();
        diaporama.setName("Titre du diaporama Essai2");
        diaporama.setCategory(category);
        diaporama.setPublished(Publish.OFF);

        categoryRepository.save(diaporama.getCategory());

        return  diaporama;
    }


    private List<Slide> generateSampleSlides(){
        List<Slide> slides = new ArrayList<>();

        Slide slide = new Slide();
        slide.setImageReference("Paris_Eiffel_Tower.jpg");
        slide.setOrdering(1);
        generateSentenceForThisSlide(slide, "Eiffel Tower");

        Slide slide2 = new Slide();
        slide2.setImageReference("Paris_Notre_Dame.jpg");
        slide2.setOrdering(2);
        generateSentenceForThisSlide(slide2, "Notre Dame Cathedral");

        slides.add(slide);
        slides.add(slide2);

        return slides;
    }

    private void generateSentenceForThisSlide(Slide slide, String content){
        VirtualSentence virtualSentence = new VirtualSentence(1L, FrontTemplate.BtmLeft);
        VirtualSentence virtualSentence2 = new VirtualSentence(2L, FrontTemplate.TopLeft);
        slide.addSentence(virtualSentence);
        slide.addSentence(virtualSentence2);
    }
}
