package com.example.demo.service;

import com.example.demo.entity.RetetaIngredient;

import java.util.List;
import java.util.Optional;

public interface RetetaIngredientService {
    List<RetetaIngredient> findAll();
    Optional<RetetaIngredient> findById(Integer id);
    RetetaIngredient save(RetetaIngredient retetaIngredient);
    void deleteById(Integer id);

    List<RetetaIngredient> findByRetetaId(Integer idReteta);
    List<RetetaIngredient> findByIngredientId(Integer idIngredient);
}
