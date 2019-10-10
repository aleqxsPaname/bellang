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
        System.out.println("DISPLAY BEFORE SPRING CONTEXT LOADING");
        SpringApplication.run(Application.class, args);
    }

    public void run(String... args) {
        System.out.println("DISPLAY AFTER SPRING CONTEXT LOADING");
        serviceEssai.methodEssai();
    }

}