package com.university.uch_university.Service;

import com.university.uch_university.Models.Meters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MetersService extends BaseService<Meters, UUID> {
    @Autowired
    public MetersService(JpaRepository<Meters, UUID> repository) {
        super(repository);
    }
}
