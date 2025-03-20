package com.University.uch_University.service;

import com.University.uch_University.model.Owner;
import com.University.uch_University.repository.OwnerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    public Owner getOwnerById(UUID id) {
        return ownerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Owner not found"));
    }

    public void saveOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public void deleteOwner(UUID id) {
        ownerRepository.deleteById(id);
    }
}
