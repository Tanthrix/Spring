package com.University.uch_University.service;

import com.University.uch_University.model.Cat;
import com.University.uch_University.repository.CatRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class CatService {

    @Autowired
    private CatRepository catRepository;

    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }

    public Cat getCatById(UUID id) {
        return catRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cat not found"));
    }

    public void saveCat(Cat cat) {
        catRepository.save(cat);
    }

    public void deleteCat(UUID id) {
        catRepository.deleteById(id);
    }
}