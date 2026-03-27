package com.example.demo.service.impl;

import com.example.demo.entity.RetetaIngredient;
import com.example.demo.repository.RetetaIngredientRepository;
import com.example.demo.service.RetetaIngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetetaIngredientServiceImpl implements RetetaIngredientService {

    private final RetetaIngredientRepository retetaIngredientRepository;

    public RetetaIngredientServiceImpl(RetetaIngredientRepository retetaIngredientRepository) {
        this.retetaIngredientRepository = retetaIngredientRepository;
    }

    @Override
    public List<RetetaIngredient> findAll() {
        return retetaIngredientRepository.findAll();
    }

    @Override
    public Optional<RetetaIngredient> findById(Integer id) {
        return retetaIngredientRepository.findById(id);
    }

    @Override
    public RetetaIngredient save(RetetaIngredient retetaIngredient) {
        return retetaIngredientRepository.save(retetaIngredient);
    }

    @Override
    public void deleteById(Integer id) {
        retetaIngredientRepository.deleteById(id);
    }

    @Override
    public List<RetetaIngredient> findByRetetaId(Integer idReteta) {
        return retetaIngredientRepository.findByReteta_IdReteta(idReteta);
    }

    @Override
    public List<RetetaIngredient> findByIngredientId(Integer idIngredient) {
        return retetaIngredientRepository.findByIngredient_IdIngredient(idIngredient);
    }
}
