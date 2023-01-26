package com.example.workshopmanagementapp.model;

import com.example.workshopmanagementapp.exceptions.MechanicNotEmptyException;
import com.example.workshopmanagementapp.exceptions.TaskNotFoundException;
import com.example.workshopmanagementapp.model.Task;
import com.example.workshopmanagementapp.model.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> listAll(){
        return (List<Task>) taskRepository.findAll();
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public Task getById(Integer id) throws TaskNotFoundException {
        Optional<Task> result = taskRepository.findById(id);
        if (result.isPresent()){
            return result.get();
        }
            throw new TaskNotFoundException("Brak zadania o podanym ID");

    }

    public void deleteById(Integer id) throws TaskNotFoundException, MechanicNotEmptyException {
        Long count = taskRepository.countById(id);
        if (count==null || count.equals(0)){
            throw new TaskNotFoundException("Brak zadania o podanym ID");
        }
        if (!taskRepository.getById(id).getMechanic().equals(null)) {
            throw new MechanicNotEmptyException("Zadanie ma przypisanego mechanika.");
        }
        taskRepository.deleteById(id);

    }
}
