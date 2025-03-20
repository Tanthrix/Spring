package com.University.uch_University.controllers;

import com.University.uch_University.model.Treatment;
import com.University.uch_University.service.TreatmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping("/treatments")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentService;

    @GetMapping("/all")
    public String getAllTreatments(Model model) {
        model.addAttribute("treatments", treatmentService.getAllTreatments());
        model.addAttribute("treatment", new Treatment());
        return "treatmentList";
    }

    @PostMapping("/add")
    public String addTreatment(@Valid @ModelAttribute("treatment") Treatment treatment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("treatments", treatmentService.getAllTreatments());
            return "treatmentList";
        }
        treatmentService.saveTreatment(treatment);
        return "redirect:/treatments/all";
    }

    @PostMapping("/update")
    public String updateTreatment(@Valid @ModelAttribute("treatment") Treatment treatment, BindingResult result) {
        treatmentService.saveTreatment(treatment);
        return "redirect:/treatments/all";
    }

    @PostMapping("/delete")
    public String deleteTreatment(@RequestParam UUID id) {
        treatmentService.deleteTreatment(id);
        return "redirect:/treatments/all";
    }
}