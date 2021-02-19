package com.bellang.model.repository;

import com.bellang.model.entity.Diaporama;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiaporamaRepository extends JpaRepository<Diaporama, Long> {


}
