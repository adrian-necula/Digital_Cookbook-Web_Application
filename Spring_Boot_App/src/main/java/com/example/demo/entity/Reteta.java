package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "retete")
public class Reteta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreteta")
    private Integer idReteta;

    @Column(name = "NumeReteta", length = 100)
    private String numeReteta;

    @Column(name = "Descriere", length = 255)
    private String descriere;

    @Column(name = "TimpPreparareMin")
    private Integer timpPreparareMin;

    @Column(name = "Portii")
    private Integer portii;

    @OneToMany(mappedBy = "reteta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RetetaIngredient> retetaIngrediente = new ArrayList<>();

    public Reteta() {}

    public Reteta(String numeReteta, String descriere, Integer timpPreparareMin, Integer portii) {
        this.numeReteta = numeReteta;
        this.descriere = descriere;
        this.timpPreparareMin = timpPreparareMin;
        this.portii = portii;
    }

    public Integer getIdReteta() { return idReteta; }
    public void setIdReteta(Integer idReteta) { this.idReteta = idReteta; }

    public String getNumeReteta() { return numeReteta; }
    public void setNumeReteta(String numeReteta) { this.numeReteta = numeReteta; }

    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }

    public Integer getTimpPreparareMin() { return timpPreparareMin; }
    public void setTimpPreparareMin(Integer timpPreparareMin) { this.timpPreparareMin = timpPreparareMin; }

    public Integer getPortii() { return portii; }
    public void setPortii(Integer portii) { this.portii = portii; }

    public List<RetetaIngredient> getRetetaIngrediente() { return retetaIngrediente; }
    public void setRetetaIngrediente(List<RetetaIngredient> retetaIngrediente) { this.retetaIngrediente = retetaIngrediente; }
}