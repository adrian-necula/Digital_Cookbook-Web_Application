package com.example.demo.service.impl;

import com.example.demo.entity.Reteta;
import com.example.demo.repository.RetetaRepository;
import com.example.demo.service.RetetaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetetaServiceImpl implements RetetaService {

    private final RetetaRepository retetaRepository;

    public RetetaServiceImpl(RetetaRepository retetaRepository) {
        this.retetaRepository = retetaRepository;
    }

    @Override
    public List<Reteta> findAll() {
        return retetaRepository.findAll();
    }

    @Override
    public Optional<Reteta> findById(Integer id) {
        return retetaRepository.findById(id);
    }

    @Override
    public Reteta save(Reteta reteta) {
        return retetaRepository.save(reteta);
    }

    @Override
    public void deleteById(Integer id) {
        retetaRepository.deleteById(id);
    }
}
