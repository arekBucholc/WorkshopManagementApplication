package com.example.workshopmanagementapp.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task,Integer> {
    public Long countById(Integer id);


}
