package com.example.EvalChou;

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
//    @RequestBody TaskList taskList,
    @PostMapping("/register/{name}")
    public TaskList addTasklist(@PathVariable("name") String name){
        TaskList taskList=new TaskList();
        taskList.setTaskListName(name);
        taskLists=taskListRepository.findAll();

        for(TaskList tasklistBDD:taskLists){
            if(tasklistBDD.getTaskListName().equals(taskList.getTaskListName())){

                return  null;
            }

        }

        taskListRepository.save(taskList);

        taskLists=taskListRepository.findAll();

        for(TaskList tasklistBDD:taskLists){
            if(tasklistBDD.getTaskListName().equals(taskList.getTaskListName())){

               return tasklistBDD;
            }

        }


        return taskList;
    }

}
