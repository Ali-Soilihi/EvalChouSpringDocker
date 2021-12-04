package com.example.EvalChou;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasklist")
public class TaskListController {
    public TaskListController(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    private TaskListRepository taskListRepository;

}
