package com.university.uch_university.Service;

import com.university.uch_university.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReadingsService extends BaseService<Readings, UUID> {
    public ReadingsService(JpaRepository<Readings, UUID> repository) {
        super(repository);
    }
}
