package com.bellang;


import com.bellang.service.ServiceRecupData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application implements CommandLineRunner {



    @Autowired
    private ServiceRecupData serviceEssai;

    public static void main(String[] args) {
        System.out.println("DISPLAY BEFORE SPRING CONTEXT LOADING");
        SpringApplication.run(Application.class, args);
    }

    public void run(String... args) {
        System.out.println("DISPLAY AFTER SPRING CONTEXT LOADING");


        serviceEssai.methodEssai();
    }

}