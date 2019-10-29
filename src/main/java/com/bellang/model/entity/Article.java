package com.bellang.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


public class Article {

    @Getter
    @Setter
    private List<Phrase> phrases = new ArrayList<>();


    public String toString(){
        String result = "";
        String separateur = "";
        int compteur = 0;
        for(Phrase phrase:phrases){
            compteur++;
            if(compteur!=1){
                separateur=" ";
            }
            result+=separateur + phrase.getContent();
        }
        return result;
    }



}
