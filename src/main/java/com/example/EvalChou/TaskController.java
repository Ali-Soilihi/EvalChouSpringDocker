package com.example.EvalChou;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private TaskRepository taskRepository;


    private static List<Task> collaboraters=new ArrayList<>();

    @GetMapping("/all")
    public List<Task> getall(){

        collaboraters=taskRepository.findAll();


        return collaboraters;
    }
}
