package com.bellang.restController;

import com.bellang.model.entity.Diaporama;
import com.bellang.model.entity.Sentence;

import com.bellang.service.DiaporamaService;
import com.bellang.service.FullDiaporamaCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DiaporamaController {


    @Autowired
    private DiaporamaService diaporamaService;

    @Autowired
    private FullDiaporamaCreationService fullDiaporamaCreation;




    @GetMapping("/diaporama")
    public Diaporama method(){

        return fullDiaporamaCreation.generateFullDiaporama();
    }

    @GetMapping("/diaporama/{id}")
    public Diaporama getDiaporamaById(@PathVariable("id") Long id){

        Diaporama diaporama = diaporamaService.getDiaporamaFromId(id);
        return diaporama;
    }

    @GetMapping("/diaporama/{id}/sentence")
    public List<Sentence> getAllSentencesForADiaporama(@PathVariable("id") Long id){
        Diaporama diaporama = diaporamaService.getDiaporamaFromId(id);
        List<Sentence> sentences = diaporamaService.getOnlySentencesOfDiaporama(diaporama);
        return sentences;
    }

}
