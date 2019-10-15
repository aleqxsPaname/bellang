package com.bellang.model.repository;

import com.bellang.model.entity.Phrase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhraseRepository extends CrudRepository<Phrase, Long> {

    List<Phrase> findAll();
}
