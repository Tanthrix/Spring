package com.university.uch_university.Service;

import com.university.uch_university.Models.Payments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentsService extends BaseService<Payments, UUID> {
    public PaymentsService(JpaRepository<Payments, UUID> repository) {
        super(repository);
    }
}
