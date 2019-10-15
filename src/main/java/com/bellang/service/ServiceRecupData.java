package com.bellang.service;

import com.bellang.model.entity.Phrase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceRecupData {

    @Autowired
    private EntityManager em;

    @Transactional
    public void methodEssai(){
        Phrase phrase = new Phrase("ajout via entityManager", "FR");
        em.persist(phrase);
    }

    private void displayPhrase(List<Phrase> phrases) {
        for(Phrase phrasei:phrases){
            System.out.println("phrase => " + phrasei.getContent());
        }
    }

}
