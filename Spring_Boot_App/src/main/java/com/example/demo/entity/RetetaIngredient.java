package com.example.demo.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "reteta_ingredient")
public class RetetaIngredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idreteta_ingredient")
    private Integer idRetetaIngredient;

    @ManyToOne
    @JoinColumn(name = "idreteta", referencedColumnName = "idreteta")
    private Reteta reteta;

    @ManyToOne
    @JoinColumn(name = "idingredient", referencedColumnName = "idingredient")
    private Ingredient ingredient;

    @Column(name = "Cantitate", precision = 10, scale = 2)
    private BigDecimal cantitate;

    @Column(name = "Unitate", length = 20)
    private String unitate;

    public RetetaIngredient() {}

    public Integer getIdRetetaIngredient() { return idRetetaIngredient; }
    public void setIdRetetaIngredient(Integer idRetetaIngredient) { this.idRetetaIngredient = idRetetaIngredient; }

    public Reteta getReteta() { return reteta; }
    public void setReteta(Reteta reteta) { this.reteta = reteta; }

    public Ingredient getIngredient() { return ingredient; }
    public void setIngredient(Ingredient ingredient) { this.ingredient = ingredient; }

    public BigDecimal getCantitate() { return cantitate; }
    public void setCantitate(BigDecimal cantitate) { this.cantitate = cantitate; }

    public String getUnitate() { return unitate; }
    public void setUnitate(String unitate) { this.unitate = unitate; }
}