package com.University.uch_University.service;

import com.University.uch_University.model.Appointment;
import com.University.uch_University.repository.AppointmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment getAppointmentById(UUID id) {
        return appointmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Appointment not found"));
    }

    public void saveAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void deleteAppointment(UUID id) {
        appointmentRepository.deleteById(id);
    }
}
