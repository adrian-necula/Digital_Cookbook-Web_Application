package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Reteta;
import com.example.demo.service.RetetaService;

@Controller
public class RetetaController {

    private final RetetaService retetaService;

    public RetetaController(RetetaService retetaService) {
        this.retetaService = retetaService;
    }

    @GetMapping("/retete")
    public String listRetete(Model model) {
        model.addAttribute("retete", retetaService.findAll());
        return "retete";
    }

    @GetMapping("/retete/new")
    public String createRetetaForm(Model model) {
        model.addAttribute("reteta", new Reteta());
        return "create_reteta";
    }

    @PostMapping("/retete")
    public String saveReteta(@ModelAttribute("reteta") Reteta reteta) {
        retetaService.save(reteta);
        return "redirect:/retete";
    }

    @GetMapping("/retete/edit/{idreteta}")
    public String editRetetaForm(@PathVariable Integer idreteta, Model model) {
        Reteta reteta = retetaService.findById(idreteta).orElse(null);
        if (reteta == null) {
            return "redirect:/retete";
        }
        model.addAttribute("reteta", reteta);
        return "edit_reteta";
    }

    @PostMapping("/retete/{idreteta}")
    public String updateReteta(@PathVariable Integer idreteta,
                               @ModelAttribute("reteta") Reteta reteta) {
        Reteta existenta = retetaService.findById(idreteta).orElse(null);
        if (existenta == null) {
            return "redirect:/retete";
        }

        existenta.setNumeReteta(reteta.getNumeReteta());
        existenta.setDescriere(reteta.getDescriere());
        existenta.setTimpPreparareMin(reteta.getTimpPreparareMin());
        existenta.setPortii(reteta.getPortii());

        retetaService.save(existenta);
        return "redirect:/retete";
    }

    @GetMapping("/retete/delete/{idreteta}")
    public String deleteReteta(@PathVariable Integer idreteta) {
        retetaService.deleteById(idreteta);
        return "redirect:/retete";
    }
}