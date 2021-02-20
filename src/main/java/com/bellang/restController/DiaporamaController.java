package com.bellang.restController;

import com.bellang.model.entity.Diaporama;
import com.bellang.model.entity.Version;
import com.bellang.model.entity.VirtualSentence;

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



    @GetMapping("/diaporamas")
    public List<Diaporama> method(){

        return fullDiaporamaCreation.generateFullDiaporama();
    }

    @GetMapping("/diaporamas/{id}")
    public Diaporama getDiaporamaById(@PathVariable("id") Long id){

        Diaporama diaporama = diaporamaService.getDiaporamaFromId(id);
        return diaporama;
    }

    @GetMapping("/diaporamas/{id}/virtualSentences")
    public List<VirtualSentence> getAllSentencesForADiaporama(@PathVariable("id") Long id){
        Diaporama diaporama = diaporamaService.getDiaporamaFromId(id);
        List<VirtualSentence> virtualSentences = diaporamaService.getOnlySentencesOfDiaporama(diaporama);
        return virtualSentences;
    }

    @GetMapping("/diaporamas/{diaporama_id}/{language}/versions")
    public List<Version> getAllVersionsForADiaporama(@PathVariable Long diaporama_id, @PathVariable String language){
        Diaporama diaporama = diaporamaService.getDiaporamaFromId(diaporama_id);
        List<Version> virtualSentences = diaporamaService.getOnlyVersionOfDiaporama(diaporama);
        return virtualSentences;
    }

}
