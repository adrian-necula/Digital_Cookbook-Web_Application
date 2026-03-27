package com.example.demo.service;

import com.example.demo.entity.Reteta;

import java.util.List;
import java.util.Optional;

public interface RetetaService {
    List<Reteta> findAll();
    Optional<Reteta> findById(Integer id);
    Reteta save(Reteta reteta);
    void deleteById(Integer id);
}
