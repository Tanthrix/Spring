package com.University.uch_University.repository;

import com.University.uch_University.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CatRepository extends JpaRepository<Cat, UUID> {
}
