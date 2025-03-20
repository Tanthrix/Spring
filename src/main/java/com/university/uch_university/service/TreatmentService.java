package com.University.uch_University.service;

import com.University.uch_University.model.Treatment;
import com.University.uch_University.repository.TreatmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepository;

    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    public Treatment getTreatmentById(UUID id) {
        return treatmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Treatment not found"));
    }

    public void saveTreatment(Treatment treatment) {
        treatmentRepository.save(treatment);
    }

    public void deleteTreatment(UUID id) {
        treatmentRepository.deleteById(id);
    }
}
