package com.bellang.service;

import com.bellang.model.entity.Diaporama;
import com.bellang.model.entity.Sentence;
import com.bellang.model.repository.DiaporamaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DiaporamaService {

    @Autowired
    private DiaporamaRepository diaporamaRepository;


    public void sayHello(){
        System.out.println("HELLO FROM DIAPORAMA SERVICE");
    }
    public Diaporama getDiaporamaFromId(Long id){
        Diaporama diaporama = diaporamaRepository.findById(id).orElse(new Diaporama());

        return diaporama;
    }


    public List<Sentence> getOnlySentencesOfDiaporama(Diaporama diaporama){
        List<Sentence> sentences = diaporama.getSlides().stream()
                                        .map(s -> s.getSentences())
                                        .flatMap(List::stream)
                                        .collect(toList());
        return sentences;
    }

}
