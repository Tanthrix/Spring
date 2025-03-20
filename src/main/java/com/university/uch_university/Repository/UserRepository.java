package com.university.uch_university.Repository;

import com.university.uch_university.Models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<Users, UUID> {
    Users findUsersById(UUID id);

    Users findUsersByProfile(Profile profile);
}
