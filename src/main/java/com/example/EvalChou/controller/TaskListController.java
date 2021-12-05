package com.example.EvalChou.controller;


import com.example.EvalChou.model.Task;
import com.example.EvalChou.model.TaskList;
import com.example.EvalChou.repository.TaskListRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasklist")
public class TaskListController {
    public TaskListController(TaskListRepository taskListRepository) {
        this.taskListRepository = taskListRepository;
    }

    private TaskListRepository taskListRepository;

    private static List<TaskList> taskLists=new ArrayList<>();

    @GetMapping("/all")
    public List<TaskList> getall(){

        taskLists=taskListRepository.findAll();


        return taskLists;
    }

    @GetMapping("{id}/taskListBox")

    public List<Task> gettaskListBox(@PathVariable("id") Integer idtaskList){
        List<Task> taskListBoxremider=new ArrayList<>();

        taskLists=taskListRepository.findAll();
        for(TaskList tasklistBDD:taskLists){
            if(tasklistBDD.getId().equals(idtaskList)){
                taskListBoxremider=tasklistBDD.getTaskListBox();
            }

        }


        return taskListBoxremider;
    }



    @PostMapping("/register")

    public TaskList addTasklist(@RequestBody TaskList taskList){


        taskLists=taskListRepository.findAll();
        for(TaskList tasklistBDD:taskLists){
            if(tasklistBDD.getTask_list_name().equals(taskList.getTask_list_name())){

                return  null;
            }

        }

        taskListRepository.save(taskList);


        taskLists=taskListRepository.findAll();
        for(TaskList tasklistBDD:taskLists){
            if(tasklistBDD.getTask_list_name().equals(taskList.getTask_list_name())){

               return tasklistBDD;
            }

        }


        return taskList;
    }

}
