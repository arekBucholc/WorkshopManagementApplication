package com.example.workshopmanagementapp.model;


import com.example.workshopmanagementapp.exceptions.MechanicNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MechanicService {
    private final MechanicRepository mechanicRepository;
    private final TaskRepository taskRepository;


    public MechanicService(MechanicRepository mechanicRepository, TaskRepository taskRepository1) {
        this.mechanicRepository = mechanicRepository;
        this.taskRepository = taskRepository1;
    }

    public List<Mechanic> listAll() {
        return mechanicRepository.findAll();
    }

    public void save(Mechanic mechanic) {
        mechanicRepository.save(mechanic);
    }

    public Mechanic getById(Integer id) throws MechanicNotFoundException {
        Optional<Mechanic> result = mechanicRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        }
        throw new MechanicNotFoundException("Brak mechanika o podanym ID");
    }

    public void deleteById(Integer mechanicId) throws MechanicNotFoundException {
        Long count = mechanicRepository.countById(mechanicId);
        if (count == null) {
            throw new MechanicNotFoundException("Brak mechanika o podanym ID");
        }


        List<Task> allTasks = taskRepository.findAll();
        List<Mechanic> allMechanics = mechanicRepository.findAll();

        for (Task task : allTasks) {
            if (task.getMechanic().getId().equals(mechanicId)) {
                task.setMechanic(allMechanics.listIterator().next());
            }
        }

        mechanicRepository.deleteById(mechanicId);


    }


}
