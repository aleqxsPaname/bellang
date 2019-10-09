package com.bellang.back;

import com.bellang.back.service.ServiceEssai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    @Autowired
    private ServiceEssai serviceEssai;

    public static void main(String[] args) {
        System.out.println("TEST D AFFICHAGE");
        //run();
        SpringApplication.run(Application.class, args);
    }


    private void run(String... args) {
        System.out.println("OK FONCTIONNE ON EST DS RUN DE APPLICATION");
        serviceEssai.methodEssai();
    }

}