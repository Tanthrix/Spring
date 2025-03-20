package com.university.uch_university.Repository;

import com.university.uch_university.Models.Tariffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TariffsRepository extends JpaRepository<Tariffs, UUID> {
}
