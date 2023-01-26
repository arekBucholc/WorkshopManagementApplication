package com.example.workshopmanagementapp.controller;

import com.example.workshopmanagementapp.exceptions.MechanicNotEmptyException;
import com.example.workshopmanagementapp.model.Mechanic;
import com.example.workshopmanagementapp.model.MechanicService;
import com.example.workshopmanagementapp.model.Task;
import com.example.workshopmanagementapp.exceptions.TaskNotFoundException;
import com.example.workshopmanagementapp.model.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;
    private final MechanicService mechanicService;

    public TaskController(TaskService taskService, MechanicService mechanicService) {
        this.taskService = taskService;
        this.mechanicService = mechanicService;
    }

    @GetMapping("/tasks")
    public String showTaskList(Model model){
        List<Task> taskList = taskService.listAll();
        model.addAttribute("taskList",taskList);

        return "tasks";
    }

    @GetMapping("/tasks/new")
    public String showNewTaskForm(Model model){
        List<Mechanic> mechanicList = mechanicService.listAll();
        model.addAttribute("task",new Task());
        model.addAttribute("mechanicList",mechanicList);
        model.addAttribute("pageTitle","Dodaj Zadanie");
        return "task_form";
    }

    @GetMapping("/tasks/save")
    public String saveTask(Task task, RedirectAttributes redirectAttributes){
        taskService.save(task);
        redirectAttributes.addFlashAttribute("message","Zapisano zadanie");
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/details")
    public String showTaskDetails(@PathVariable Integer id, Model model) throws TaskNotFoundException {
        Task task = taskService.getById(id);
        model.addAttribute("task", task);
        model.addAttribute("pageTitle","Szczególy zadania (ID: "+id+")");

        return "task_details";
    }

    @GetMapping("/tasks/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes){
        try {
            Task task = taskService.getById(id);
            List<Mechanic> mechanicList = mechanicService.listAll();
            model.addAttribute("task", task);
            model.addAttribute("mechanicList",mechanicList);
            model.addAttribute("pageTitle","Edytuj Zadanie (ID: "+id+")");

            taskService.save(task);

            return "task_form";
        } catch (TaskNotFoundException e) {
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            e.printStackTrace();
            return "redirect:/tasks";
        }
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        try {
            taskService.deleteById(id);
            redirectAttributes.addFlashAttribute("message","Zadanie o ID : "+id+" zostało usunięte");
        } catch (TaskNotFoundException | MechanicNotEmptyException e) {
            if (e.getClass().equals(TaskNotFoundException.class)){
                redirectAttributes.addFlashAttribute("message",e.getMessage());
            }else {
                redirectAttributes.addFlashAttribute("message",e.getMessage());
            }

        }
        return "redirect:/tasks";
    }
}
