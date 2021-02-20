package com.bellang.service;

import com.bellang.model.entity.Diaporama;
import com.bellang.model.entity.Version;
import com.bellang.model.entity.VirtualSentence;
import com.bellang.model.entity.Slide;
import com.bellang.model.enumType.FrontTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
        Diaporama diaporama = createDiaporamaWith1SlideAnd3VirtualSentences();

        //WHEN
        List<VirtualSentence> virtualSentenceList = diaporamaService.getOnlySentencesOfDiaporama(diaporama);

        //THEN
        assertThat(virtualSentenceList.size()).isEqualTo(3);
    }

    @Test
    public void should_return_a_list_of_5_element(){

        //GIVEN
        Diaporama diaporama = createDiaporamaWith1SlideAnd3VirtualSentences();
        Slide slide = createASlideWith2Sentences();
        diaporama.addSlide(slide);

        //WHEN
        List<VirtualSentence> virtualSentenceList = diaporamaService.getOnlySentencesOfDiaporama(diaporama);

        //THEN
        assertThat(virtualSentenceList.size()).isEqualTo(5);
    }

    @Test
    public void should_retrun_3_versions(){

        // GIVEN
        Diaporama diaporama = createDiaporamaWith1SlideAnd3VirtualSentences();
        diaporama = addVersionToEachSentencesOfThisDiaporama(diaporama);

        // WHEN
        List<Version> versions = diaporamaService.getOnlyVersionOfDiaporama(diaporama);

        // THEN
        assertThat(versions.size()).isEqualTo(3);
        assertThat(versions.get(0).getContent()).isEqualTo("Hello1");

    }

    private Diaporama addVersionToEachSentencesOfThisDiaporama(Diaporama diaporama){
        VirtualSentence vs1 = diaporama.getSlides().get(0).getVirtualSentences().get(0);
        VirtualSentence vs2 = diaporama.getSlides().get(0).getVirtualSentences().get(1);
        VirtualSentence vs3 = diaporama.getSlides().get(0).getVirtualSentences().get(2);
        Version version1 = new Version(vs1,"EN", "Hello1");
        vs1.addVersion(version1);
        Version version2 = new Version(vs2,"EN", "Hello2");
        vs2.addVersion(version2);
        Version version3 = new Version(vs3,"EN", "Hello3");
        vs3.addVersion(version3);
        return diaporama;
    }

    private Diaporama createDiaporamaWith1SlideAnd3VirtualSentences(){
        Diaporama diaporama = new Diaporama();
        Slide slide1 = new Slide();
        VirtualSentence virtualSentence2 = new VirtualSentence(2L, FrontTemplate.MiddleLeft);
        VirtualSentence virtualSentence1 = new VirtualSentence(1L, FrontTemplate.TopLeft);
        VirtualSentence virtualSentence3 = new VirtualSentence(3L, FrontTemplate.BtmLeft);
        slide1.addSentence(virtualSentence2);
        slide1.addSentence(virtualSentence1);
        slide1.addSentence(virtualSentence3);
        diaporama.addSlide(slide1);
        return diaporama;
    }

    private Slide createASlideWith2Sentences() {
        Slide slide2 = new Slide();
        VirtualSentence virtualSentence2_2 = new VirtualSentence(2L, FrontTemplate.MiddleLeft);
        VirtualSentence virtualSentence2_1 = new VirtualSentence(1L, FrontTemplate.TopLeft);
        slide2.addSentence(virtualSentence2_2);
        slide2.addSentence(virtualSentence2_1);
        return slide2;
    }


}