package com.bellang.back;

import com.bellang.back.service.ServiceEssai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ServiceEssai serviceEssai;

    public static void main(String[] args) {
        System.out.println("TEST D AFFICHAGE");

        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
    }


    public void run(String... args) {
        System.out.println("OK FONCTIONNE ON EST DS RUN DE APPLICATION");
        serviceEssai.methodEssai();
    }

}