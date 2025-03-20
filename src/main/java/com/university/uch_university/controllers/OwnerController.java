package com.University.uch_University.controllers;

import com.University.uch_University.model.Owner;
import com.University.uch_University.service.ClinicService;
import com.University.uch_University.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private ClinicService clinicService;

    @GetMapping("/all")
    public String getAllOwners(Model model) {
        model.addAttribute("owners", ownerService.getAllOwners());
        model.addAttribute("owner", new Owner());
        model.addAttribute("clinics", clinicService.getAllClinics());
        return "ownerList";
    }

    @PostMapping("/add")
    public String addOwner(@Valid @ModelAttribute("owner") Owner owner, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("owners", ownerService.getAllOwners());
            model.addAttribute("clinics", clinicService.getAllClinics());
            return "ownerList";
        }
        ownerService.saveOwner(owner);
        return "redirect:/owners/all";
    }

    @PostMapping("/update")
    public String updateOwner(@Valid @ModelAttribute("owner") Owner owner, BindingResult result) {
        ownerService.saveOwner(owner);
        return "redirect:/owners/all";
    }

    @PostMapping("/delete")
    public String deleteOwner(@RequestParam UUID id) {
        ownerService.deleteOwner(id);
        return "redirect:/owners/all";
    }
}
