package com.project.portfolio.TheTaskManager.repository;

import com.project.portfolio.TheTaskManager.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
}
