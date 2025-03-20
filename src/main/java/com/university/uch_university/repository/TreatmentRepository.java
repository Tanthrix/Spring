package com.University.uch_University.repository;

import com.University.uch_University.model.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, UUID> {
}
