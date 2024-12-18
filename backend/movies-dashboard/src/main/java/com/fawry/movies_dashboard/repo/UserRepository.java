package com.fawry.movies_dashboard.repo;

import com.fawry.movies_dashboard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}