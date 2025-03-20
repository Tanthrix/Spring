package com.University.uch_University.controllers;

import com.University.uch_University.model.Clinic;
import com.University.uch_University.service.ClinicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/clinics")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @GetMapping("/all")
    public String getAllClinics(Model model) {
        model.addAttribute("clinics", clinicService.getAllClinics());
        model.addAttribute("clinic", new Clinic());
        return "clinicList";
    }

    @PostMapping("/add")
    public String addClinic(@Valid @ModelAttribute("clinic") Clinic clinic, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("clinics", clinicService.getAllClinics());
            return "clinicList";
        }
        clinicService.saveClinic(clinic);
        return "redirect:/clinics/all";
    }

    @PostMapping("/update")
    public String updateClinic(@Valid @ModelAttribute("clinic") Clinic clinic, BindingResult result) {
        clinicService.saveClinic(clinic);
        return "redirect:/clinics/all";
    }

    @PostMapping("/delete")
    public String deleteClinic(@RequestParam UUID id) {
        clinicService.deleteClinic(id);
        return "redirect:/clinics/all";
    }
}
