package com.example.demo.service;

import com.example.demo.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    List<Ingredient> findAll();
    Optional<Ingredient> findById(Integer id);
    Ingredient save(Ingredient ingredient);
    void deleteById(Integer id);
}
