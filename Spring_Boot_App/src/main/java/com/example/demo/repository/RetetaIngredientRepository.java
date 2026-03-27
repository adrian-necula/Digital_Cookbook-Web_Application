package com.example.demo.repository;

import com.example.demo.entity.RetetaIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RetetaIngredientRepository extends JpaRepository<RetetaIngredient, Integer> {
    
    List<RetetaIngredient> findByReteta_IdReteta(Integer idReteta);

    List<RetetaIngredient> findByIngredient_IdIngredient(Integer idIngredient);
}