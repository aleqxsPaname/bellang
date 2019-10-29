package com.bellang.model.entity;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class ArticleTest {




    public List<Phrase> setUpAlistOf3Phrase(){
        Phrase phrase1 = new Phrase("phrase1", "DE");
        Phrase phrase2 = new Phrase("phrase2", "DE");
        Phrase phrase3 = new Phrase("phrase3", "DE");
        return Arrays.asList(phrase1, phrase2, phrase3);
    }

    @Test
    public void should_return_a_list_of_3_phrases(){

        // GIVEN
        List<Phrase> phraseList = setUpAlistOf3Phrase();

        // WHEN
        Article article = new Article();
        article.setPhrases(phraseList);

        // THEN
        assertThat(article.getPhrases()).hasSize(3);
    }

    @Test
    public void should_return_only_phrase_content_when_asking_for_article_toString(){

        // GIVEN
        List<Phrase> phraseList = setUpAlistOf3Phrase();
        Article article = new Article();
        article.setPhrases(phraseList);

        // WHEN
        String articleString = article.toString();

        // THEN
        assertThat(articleString).isEqualTo("phrase1 phrase2 phrase3");
    }
}