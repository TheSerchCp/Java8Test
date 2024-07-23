package com.javaprueba.JavaPrueba.controller;

import com.javaprueba.JavaPrueba.service.TaskService.TaskService;
import com.javaprueba.JavaPrueba.entity.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String goToLanding(){
        return "index";
    }

    @GetMapping("/register")
    public String goToRegister(@ModelAttribute("task") Task task, Model model){
        model.addAttribute("task", new Task());
        return "formRegister";
    }

    @GetMapping("/listTasks")
    public String goToListTasks(Model model){
        model.addAttribute("listTask", taskService.findAll());
        return "listTasks";
    }


    @PostMapping("/addTask")
    public String addTask(Task task, Model model, RedirectAttributes redirectAttributes) {
       if(taskService.save(task) > 0){
           redirectAttributes.addFlashAttribute("message", "added");
       }else{
           redirectAttributes.addFlashAttribute("message", "error");
       }

       return "redirect:/listTasks";

    }
}
