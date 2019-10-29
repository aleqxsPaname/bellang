package com.bellang.model.entity;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;


public class PhraseTest {

    @Test
    public void should_return_null(){

        // GIVEN

        // WHEN
        Phrase phrase1 = new Phrase("phrase test", "DE");

        // THEN
        assertThat(phrase1.getContent()).isEqualTo("phrase test");
        assertThat(phrase1.getLangue()).isEqualTo("DE");

    }

}