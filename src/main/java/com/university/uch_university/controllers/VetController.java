package com.University.uch_University.controllers;

import com.University.uch_University.model.Vet;
import com.University.uch_University.service.VetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping("/vets")
public class VetController {

    @Autowired
    private VetService vetService;

    @GetMapping("/all")
    public String getAllVets(Model model) {
        model.addAttribute("vets", vetService.getAllVets());
        model.addAttribute("vet", new Vet());
        return "vetList";
    }

    @PostMapping("/add")
    public String addVet(@Valid @ModelAttribute("vet") Vet vet, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("vets", vetService.getAllVets());
            return "vetList";
        }
        vetService.saveVet(vet);
        return "redirect:/vets/all";
    }

    @PostMapping("/update")
    public String updateVet(@Valid @ModelAttribute("vet") Vet vet, BindingResult result) {
        vetService.saveVet(vet);
        return "redirect:/vets/all";
    }

    @PostMapping("/delete")
    public String deleteVet(@RequestParam UUID id) {
        vetService.deleteVet(id);
        return "redirect:/vets/all";
    }
}