package com.University.uch_University.controllers;

import com.University.uch_University.model.Appointment;
import com.University.uch_University.service.AppointmentService;
import com.University.uch_University.service.CatService;
import com.University.uch_University.service.TreatmentService;
import com.University.uch_University.service.VetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private CatService catService;

    @Autowired
    private VetService vetService;
    @Autowired
    private TreatmentService treatmentService;

    @GetMapping("/all")
    public String getAllAppointments(Model model) {
        model.addAttribute("appointments", appointmentService.getAllAppointments());
        model.addAttribute("appointment", new Appointment());
        model.addAttribute("cats", catService.getAllCats());
        model.addAttribute("vets", vetService.getAllVets());
        model.addAttribute("treatments", treatmentService.getAllTreatments());
        return "appointmentList";
    }

    @PostMapping("/add")
    public String addAppointment(@Valid @ModelAttribute("appointment") Appointment appointment, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("appointments", appointmentService.getAllAppointments());
            model.addAttribute("cats", catService.getAllCats());
            model.addAttribute("vets", vetService.getAllVets());
            model.addAttribute("treatments", treatmentService.getAllTreatments());
            return "appointmentList";
        }
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments/all";
    }

    @PostMapping("/update")
    public String updateAppointment(@Valid @ModelAttribute("appointment") Appointment appointment, BindingResult result) {
        appointmentService.saveAppointment(appointment);
        return "redirect:/appointments/all";
    }

    @PostMapping("/delete")
    public String deleteAppointment(@RequestParam UUID id) {
        appointmentService.deleteAppointment(id);
        return "redirect:/appointments/all";
    }
}
