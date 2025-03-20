package com.university.uch_university.Service;

import com.university.uch_university.Models.Consuption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ConsuptionService extends BaseService<Consuption, UUID> {
    @Autowired
    public ConsuptionService(JpaRepository<Consuption, UUID> repository) {
        super(repository);
    }
}
