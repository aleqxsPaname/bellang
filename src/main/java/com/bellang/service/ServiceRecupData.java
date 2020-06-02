package com.bellang.service;

import com.bellang.model.entity.Phrase;
import com.bellang.model.repository.PhraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServiceRecupData {

 /*   @Autowired
    private EntityManager em;
*/
    @Autowired
    private PhraseRepository phraseRepository;

   // @Transactional
    public void methodEssai(){
        Phrase phrase = new Phrase("ajout test via Repo JPA_SPRING_DATA", "FR");
        phraseRepository.save(phrase);
       // em.persist(phrase);
    }

    private void displayPhrase(List<Phrase> phrases) {
        for(Phrase phrasei:phrases){
            System.out.println("phrase => " + phrasei.getContent());
        }
    }

}
