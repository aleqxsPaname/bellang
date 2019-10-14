package com.bellang;

import com.bellang.model.entity.Phrase;
import com.bellang.model.repository.PhraseRepository;
import com.bellang.service.ServiceEssai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    // TODO a mettre en test et dans un service pas directement ds le main
    @Autowired
    private PhraseRepository repository;


    @Autowired
    private ServiceEssai serviceEssai;

    public static void main(String[] args) {
        System.out.println("DISPLAY BEFORE SPRING CONTEXT LOADING");
        SpringApplication.run(Application.class, args);
    }

    public void run(String... args) {
        System.out.println("DISPLAY AFTER SPRING CONTEXT LOADING");
        repository.save(new Phrase("blabla", "FR"));

        List<Phrase> phrases = repository.findAll();
        for(Phrase phrase:phrases){
            System.out.println("phrase => " + phrase.getContent());
        }

        serviceEssai.methodEssai();
    }

}