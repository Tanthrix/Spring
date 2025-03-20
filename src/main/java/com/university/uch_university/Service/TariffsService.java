package com.university.uch_university.Service;

import com.university.uch_university.Models.Tariffs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TariffsService extends BaseService<Tariffs, UUID> {
    @Autowired
    public TariffsService(JpaRepository<Tariffs, UUID> repository) {
        super(repository);
    }
}