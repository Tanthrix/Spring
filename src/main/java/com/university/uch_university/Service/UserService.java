package com.university.uch_university.Service;

import com.university.uch_university.Models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService extends BaseService<Users, UUID> {
    @Autowired
    public UserService(JpaRepository<Users, UUID> repository) {
        super(repository);
    }
}

