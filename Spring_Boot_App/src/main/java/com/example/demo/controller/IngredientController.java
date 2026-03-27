package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Ingredient;
import com.example.demo.service.IngredientService;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping("/ingrediente")
    public String listIngrediente(Model model) {
        model.addAttribute("ingrediente", ingredientService.findAll());
        return "ingrediente";
    }

    @GetMapping("/ingrediente/new")
    public String createIngredientForm(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "create_ingredient";
    }

    @PostMapping("/ingrediente")
    public String saveIngredient(@ModelAttribute("ingredient") Ingredient ingredient) {
        ingredientService.save(ingredient);
        return "redirect:/ingrediente";
    }

    @GetMapping("/ingrediente/edit/{idingredient}")
    public String editIngredientForm(@PathVariable Integer idingredient, Model model) {
        Ingredient ingredient = ingredientService.findById(idingredient).orElse(null);
        if (ingredient == null) return "redirect:/ingrediente";

        model.addAttribute("ingredient", ingredient);
        return "edit_ingredient";
    }

    @PostMapping("/ingrediente/{idingredient}")
    public String updateIngredient(@PathVariable Integer idingredient,
                                   @ModelAttribute("ingredient") Ingredient ingredient) {

        Ingredient existent = ingredientService.findById(idingredient).orElse(null);
        if (existent == null) return "redirect:/ingrediente";

        existent.setNumeIngredient(ingredient.getNumeIngredient());
        existent.setAlergen(ingredient.getAlergen());

        ingredientService.save(existent);
        return "redirect:/ingrediente";
    }

    @GetMapping("/ingrediente/delete/{idingredient}")
    public String deleteIngredient(@PathVariable Integer idingredient) {
        ingredientService.deleteById(idingredient);
        return "redirect:/ingrediente";
    }
}