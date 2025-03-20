package com.university.uch_university.Repository;


import com.university.uch_university.Models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {
    Profile findByUsername(String login);

    boolean existsByUsername(String login);

    Profile findRepositoryById(UUID id);
}

