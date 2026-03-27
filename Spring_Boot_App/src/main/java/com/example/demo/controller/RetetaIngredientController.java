package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.RetetaIngredient;
import com.example.demo.repository.IngredientRepository;
import com.example.demo.repository.RetetaRepository;
import com.example.demo.service.RetetaIngredientService;

@Controller
public class RetetaIngredientController {

    private final RetetaIngredientService retetaIngredientService;
    private final RetetaRepository retetaRepo;
    private final IngredientRepository ingredientRepo;

    public RetetaIngredientController(RetetaIngredientService retetaIngredientService,
                                      RetetaRepository retetaRepo,
                                      IngredientRepository ingredientRepo) {
        this.retetaIngredientService = retetaIngredientService;
        this.retetaRepo = retetaRepo;
        this.ingredientRepo = ingredientRepo;
    }

    @GetMapping("/asocieri")
    public String listAsocieri(Model model) {
        model.addAttribute("asocieri", retetaIngredientService.findAll());
        return "asocieri";
    }

    @GetMapping("/asocieri/new")
    public String createAsociereForm(Model model) {
        model.addAttribute("toateretetele", retetaRepo.findAll());
        model.addAttribute("toateingredientele", ingredientRepo.findAll());
        model.addAttribute("asociere", new RetetaIngredient());
        return "create_asociere";
    }

    @PostMapping("/asocieri")
    public String saveAsociere(@ModelAttribute("asociere") RetetaIngredient asociere) {
        retetaIngredientService.save(asociere);
        return "redirect:/asocieri";
    }

    @GetMapping("/asocieri/edit/{idasociere}")
    public String editAsociereForm(@PathVariable Integer idasociere, Model model) {
        RetetaIngredient asociere = retetaIngredientService.findById(idasociere).orElse(null);
        if (asociere == null) return "redirect:/asocieri";

        model.addAttribute("asociere", asociere);
        model.addAttribute("toateretetele", retetaRepo.findAll());
        model.addAttribute("toateingredientele", ingredientRepo.findAll());

        return "edit_asociere";
    }

    @PostMapping("/asocieri/{idasociere}")
    public String updateAsociere(@PathVariable Integer idasociere,
                                 @ModelAttribute("asociere") RetetaIngredient asociere) {

        RetetaIngredient existent = retetaIngredientService.findById(idasociere).orElse(null);
        if (existent == null) return "redirect:/asocieri";

        existent.setReteta(asociere.getReteta());
        existent.setIngredient(asociere.getIngredient());
        existent.setCantitate(asociere.getCantitate());
        existent.setUnitate(asociere.getUnitate());

        retetaIngredientService.save(existent);
        return "redirect:/asocieri";
    }

    @GetMapping("/asocieri/delete/{idasociere}")
    public String deleteAsociere(@PathVariable Integer idasociere) {
        retetaIngredientService.deleteById(idasociere);
        return "redirect:/asocieri";
    }
}