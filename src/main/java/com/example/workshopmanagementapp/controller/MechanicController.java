package com.example.workshopmanagementapp.controller;

import com.example.workshopmanagementapp.model.Mechanic;
import com.example.workshopmanagementapp.exceptions.MechanicNotFoundException;
import com.example.workshopmanagementapp.model.MechanicService;
import com.example.workshopmanagementapp.model.Task;
import com.example.workshopmanagementapp.model.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MechanicController {
    private final MechanicService mechanicService;
    private final TaskService taskService;

    public MechanicController(MechanicService mechanicService, TaskService taskService) {
        this.mechanicService = mechanicService;
        this.taskService = taskService;
    }

    @GetMapping("/mechanics")
    public String showMechanicList(Model model){
        List<Mechanic> mechanicList = mechanicService.listAll();
        model.addAttribute("mechanicsList",mechanicList);

        return "mechanics";
    }

    @GetMapping("/mechanics/new")
    public String showNewMechanicForm(Model model){
        List<Task> taskList = taskService.listAll();
        model.addAttribute("mechanic",new Mechanic());
        model.addAttribute("pageTitle","Dodaj Mechanika");
        return "mechanic_form";
    }

    @PostMapping("/mechanics/save")
    public String saveMechanic(Mechanic mechanic, RedirectAttributes redirectAttributes){
        mechanicService.save(mechanic);
        redirectAttributes.addFlashAttribute("message","Mechanik zapisany");
        return "redirect:/mechanics";
    }

    @GetMapping("/mechanics/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model, RedirectAttributes redirectAttributes){
        try {
            Mechanic mechanic = mechanicService.getById(id);
            model.addAttribute("mechanic", mechanic);
            model.addAttribute("pageTitle","Edytuj Mechanika (ID: "+id+")");

            return "mechanic_form";
        } catch (MechanicNotFoundException e) {
            redirectAttributes.addFlashAttribute("message",e.getMessage());
            e.printStackTrace();
            return "redirect:/mechanics";
        }
    }

    @GetMapping("/mechanics/delete/{id}")
    public String deleteMechanic(@PathVariable Integer id, RedirectAttributes redirectAttributes){
        try {
            mechanicService.deleteById(id);
            redirectAttributes.addFlashAttribute("message","Mechanik o ID : "+id+" został usunięty");
        } catch (MechanicNotFoundException e) {
            redirectAttributes.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/mechanics";
    }


}
