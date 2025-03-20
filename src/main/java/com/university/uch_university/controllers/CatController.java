package com.University.uch_University.controllers;

import com.University.uch_University.model.Cat;
import com.University.uch_University.service.CatService;
import com.University.uch_University.service.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@Controller
@RequestMapping("/cats")
public class CatController {

    @Autowired
    private CatService catService;

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/all")
    public String getAllCats(Model model) {
        model.addAttribute("cats", catService.getAllCats());
        model.addAttribute("cat", new Cat());
        model.addAttribute("owners", ownerService.getAllOwners());
        return "catList";
    }

    @PostMapping("/add")
    public String addCat(@Valid @ModelAttribute("cat") Cat cat, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cats", catService.getAllCats());
            model.addAttribute("owners", ownerService.getAllOwners());
            return "catList";
        }
        catService.saveCat(cat);
        return "redirect:/cats/all";
    }

    @PostMapping("/update")
    public String updateCat(@Valid @ModelAttribute("cat") Cat cat, BindingResult result) {
        catService.saveCat(cat);
        return "redirect:/cats/all";
    }

    @PostMapping("/delete")
    public String deleteCat(@RequestParam UUID id) {
        catService.deleteCat(id);
        return "redirect:/cats/all";
    }
}
