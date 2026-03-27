package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ingrediente")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idingredient")
    private Integer idIngredient;

    @Column(name = "NumeIngredient", length = 100)
    private String numeIngredient;

    @Column(name = "Alergen", length = 100)
    private String alergen;

    @OneToMany(mappedBy = "ingredient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RetetaIngredient> retetaIngrediente = new ArrayList<>();

    public Ingredient() {}

    public Ingredient(String numeIngredient, String alergen) {
        this.numeIngredient = numeIngredient;
        this.alergen = alergen;
    }

    public Integer getIdIngredient() { return idIngredient; }
    public void setIdIngredient(Integer idIngredient) { this.idIngredient = idIngredient; }

    public String getNumeIngredient() { return numeIngredient; }
    public void setNumeIngredient(String numeIngredient) { this.numeIngredient = numeIngredient; }

    public String getAlergen() { return alergen; }
    public void setAlergen(String alergen) { this.alergen = alergen; }

    public List<RetetaIngredient> getRetetaIngrediente() { return retetaIngrediente; }
    public void setRetetaIngrediente(List<RetetaIngredient> retetaIngrediente) { this.retetaIngrediente = retetaIngrediente; }
}