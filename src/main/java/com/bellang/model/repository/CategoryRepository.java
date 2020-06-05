package com.bellang.model.repository;

import com.bellang.model.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, String> {


    public Optional<Category> findByName(String name);
}
