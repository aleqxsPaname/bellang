package com.bellang.model.repository;

import com.bellang.model.entity.Category;
import com.bellang.model.entity.Diaporama;
import com.bellang.model.entity.Sentence;
import com.bellang.model.entity.Slide;
import com.bellang.model.enumType.FrontTemplate;
import com.bellang.model.enumType.Publish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@RunWith(SpringRunner.class)
public class DiaporamaRepositoryOrderingTest {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    DiaporamaRepository diaporamaRepository;

    @Autowired
    CategoryRepository categoryRepository;


    @Test
    @Transactional
    public void given_a_diaporama_with_2_disordered_slides__thoses_slides_should_be_ordered_when_retrieved_from_DB(){

        //GIVEN
        Diaporama diaporamaBeforeLoadingInDB = generateSampleDiaporama();
        List<Slide> slides = generateSampleSlides();
        diaporamaBeforeLoadingInDB.setSlides(slides);

        saveInDBWithDinstinctTransaction(diaporamaBeforeLoadingInDB);

        //WHEN
        Diaporama diaporamaRetrievedFromDB = diaporamaRepository.findAll().get(0);

        //THEN
        assertThat(diaporamaBeforeLoadingInDB.getSlides().get(0).getOrdering()).isEqualTo(2);
        assertThat(diaporamaRetrievedFromDB.getSlides().get(0).getOrdering()).isEqualTo(1);

    }

    private void saveInDBWithDinstinctTransaction(Diaporama diaporama) {

        EntityManager em = entityManagerFactory.createEntityManager();

        em.getTransaction().begin();
        em.persist(diaporama);
        em.flush();
        em.getTransaction().commit();
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
        slide.setOrdering(2);
        generateSentenceForThisSlide(slide, "Eiffel Tower");

        Slide slide2 = new Slide();
        slide2.setImageReference("Paris_Notre_Dame.jpg");
        slide2.setOrdering(1);
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