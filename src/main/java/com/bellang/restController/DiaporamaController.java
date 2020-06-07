package com.bellang.restController;

import com.bellang.model.entity.Diaporama;
import com.bellang.model.repository.DiaporamaRepository;

import com.bellang.service.FullDiaporamaCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DiaporamaController {


    @Autowired
    private DiaporamaRepository diaporamaRepository;

    @Autowired
    private FullDiaporamaCreationService fullDiaporamaCreation;

    @GetMapping("/diaporama")
    public Diaporama method(){

        return fullDiaporamaCreation.generateFullDiaporama();
    }

    @GetMapping("/diaporama/{id}")
    public Diaporama method(@PathVariable("id") Long id){

        Diaporama diaporama = diaporamaRepository.findById(id).orElse(new Diaporama());

        return diaporama;
    }

}
