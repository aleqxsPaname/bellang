package com.bellang.service;

import com.bellang.model.entity.Diaporama;
import com.bellang.model.entity.Sentence;
import com.bellang.model.entity.Slide;
import com.bellang.model.enumType.FrontTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DiaporamaServiceTest {

    @Autowired
    DiaporamaService diaporamaService;

    @Test
    public void should_return_a_list_of_3_element(){

        //GIVEN
        Diaporama diaporama = new Diaporama();
        Slide slide1 = new Slide();
        Sentence sentence2 = new Sentence("sentence_2", FrontTemplate.MiddleLeft);
        Sentence sentence1 = new Sentence("sentence_1", FrontTemplate.TopLeft);
        Sentence sentence3 = new Sentence("sentence_3", FrontTemplate.BtmLeft);
        slide1.addSentence(sentence2);
        slide1.addSentence(sentence1);
        slide1.addSentence(sentence3);
        diaporama.addSlide(slide1);

        //WHEN
        diaporamaService.sayHello();
        List<Sentence> sentenceList = diaporamaService.getOnlySentencesOfDiaporama(diaporama);

        //THEN
        assertThat(sentenceList.size()).isEqualTo(3);
    }

    @Test
    public void should_return_a_list_of_5_element(){

        //GIVEN
        Diaporama diaporama = new Diaporama();
        Slide slide1 = new Slide();
        Sentence sentence2 = new Sentence("sentence_2", FrontTemplate.MiddleLeft);
        Sentence sentence1 = new Sentence("sentence_1", FrontTemplate.TopLeft);
        Sentence sentence3 = new Sentence("sentence_3", FrontTemplate.BtmLeft);
        slide1.addSentence(sentence2);
        slide1.addSentence(sentence1);
        slide1.addSentence(sentence3);
        diaporama.addSlide(slide1);

        Slide slide2 = new Slide();
        Sentence sentence2_2 = new Sentence("sentence_2", FrontTemplate.MiddleLeft);
        Sentence sentence2_1 = new Sentence("sentence_1", FrontTemplate.TopLeft);
        slide2.addSentence(sentence2);
        slide2.addSentence(sentence1);
        diaporama.addSlide(slide2);

        //WHEN
        diaporamaService.sayHello();
        List<Sentence> sentenceList = diaporamaService.getOnlySentencesOfDiaporama(diaporama);

        //THEN
        assertThat(sentenceList.size()).isEqualTo(5);
    }

}