package com.university.uch_university.Service;

import com.university.uch_university.Models.PaymentsMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentsMethodService extends BaseService<PaymentsMethod, UUID> {
    @Autowired
    public PaymentsMethodService(JpaRepository<PaymentsMethod, UUID> repository) {
        super(repository);
    }
}
