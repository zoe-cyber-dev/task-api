package org.zoecyberdev.taskapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zoecyberdev.taskapi.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
