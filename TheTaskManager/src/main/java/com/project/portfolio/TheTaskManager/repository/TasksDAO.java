package com.project.portfolio.TheTaskManager.repository;

import com.project.portfolio.TheTaskManager.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksDAO extends JpaRepository<Task, Long> {
}
