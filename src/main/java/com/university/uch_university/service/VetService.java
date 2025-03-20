package com.University.uch_University.service;

import com.University.uch_University.model.Vet;
import com.University.uch_University.repository.VetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class VetService {

    @Autowired
    private VetRepository vetRepository;

    public List<Vet> getAllVets() {
        return vetRepository.findAll();
    }

    public Vet getVetById(UUID id) {
        return vetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Vet not found"));
    }

    public void saveVet(Vet vet) {
        vetRepository.save(vet);
    }

    public void deleteVet(UUID id) {
        vetRepository.deleteById(id);
    }
}
