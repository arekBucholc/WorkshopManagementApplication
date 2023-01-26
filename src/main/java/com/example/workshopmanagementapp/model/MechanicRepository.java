package com.example.workshopmanagementapp.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MechanicRepository extends JpaRepository<Mechanic,Integer> {
    Long countById(Integer id);
}
