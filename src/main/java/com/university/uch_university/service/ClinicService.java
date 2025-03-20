package com.University.uch_University.service;

import com.University.uch_University.model.Clinic;
import com.University.uch_University.repository.ClinicRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    public List<Clinic> getAllClinics() {
        return clinicRepository.findAll();
    }

    public Clinic getClinicById(UUID id) {
        return clinicRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Clinic not found"));
    }

    public void saveClinic(Clinic clinic) {
        clinicRepository.save(clinic);
    }

    public void deleteClinic(UUID id) {
        clinicRepository.deleteById(id);
    }
}
