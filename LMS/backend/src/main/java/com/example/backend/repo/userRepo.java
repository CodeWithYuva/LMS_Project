package com.example.backend.repo;

import com.example.backend.entity.progress;
import com.example.backend.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<users, Long> {
    users findByEmail(String email);
}
