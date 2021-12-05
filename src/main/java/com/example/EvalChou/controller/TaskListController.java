package com.example.EvalChou.controller;


import com.example.EvalChou.model.Task;
import com.example.EvalChou.model.TaskList;
import com.example.EvalChou.repository.TaskListRepository;
import com.example.EvalChou.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasklist")
public class TaskListController {
    private TaskRepository taskRepository;
    private TaskListRepository taskListRepository;

    public TaskListController(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }


    private static List<Task> tasks = new ArrayList<>();
    private static List<TaskList> taskLists = new ArrayList<>();

    @GetMapping("/all")
    public List<TaskList> getall() {

        taskLists = taskListRepository.findAll();


        return taskLists;
    }
    /**
     *
     * les question 7 et 6 on été abandoné mais il aurais été mis sur ce controller
     *
     * **/

    /*todo: 1-Je veux pouvoir créer une liste de tâches, en lui donnant un nom.*/
    @PostMapping("/register")
    public TaskList addTasklist(@RequestBody TaskList taskList) {

//      recherche le nom de la liste si deja presente dans la bdd renvois null
        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {
            if (tasklistBDD.getTask_list_name().equals(taskList.getTask_list_name())) {

                return null;
            }

        }
//      enregistre dans la bdd
        taskListRepository.save(taskList);

//      recherche une deuxieme fois pour affiché un objet propre
        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {
            if (tasklistBDD.getTask_list_name().equals(taskList.getTask_list_name())) {

                return tasklistBDD;
            }

        }

//      retour qui ser a rien mais au pire des cas renvois un objet vide
        return taskList;
    }

/** les methode suivante n'on pas été demander dans les question **/

    @GetMapping("{id}/taskListBox/all")
    public List<Task> gettaskListBox(@PathVariable("id") Integer idtaskList) {
        List<Task> taskListBoxremider = new ArrayList<>();

        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {
            if (tasklistBDD.getId().equals(idtaskList)) {
                taskListBoxremider = tasklistBDD.getTaskListBox();
            }

        }
        return taskListBoxremider;
    }

    @PutMapping("{id}/taskListBox/update/task/{idtask}")
    public List<Task> addtaskintaskListBox(@PathVariable("id") Integer idtaskList, @PathVariable("idtask") Integer idtask) {
        Task taskRemider = new Task();
        List<Task> taskListBoxremider = new ArrayList<>();

        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {

            if (taskBDD.getId().equals(idtask)) {
                taskRemider = taskBDD;
            }

        }

        if (taskRemider.getId() == null) {

            return null;
        }

        taskLists = taskListRepository.findAll();
        for (TaskList taskListBDD : taskLists) {

            if (taskListBDD.getId().equals(idtaskList)) {
                if (taskListBDD.getTaskListBox().contains(taskRemider)) {

                    return null;
                }
                taskListBoxremider = taskListBDD.getTaskListBox();

                taskListBoxremider.add(taskRemider);

                taskListBDD.setTaskListBox(taskListBoxremider);

                taskRemider.setTask_list_id(taskListBDD);

                taskRepository.save(taskRemider);
                taskListRepository.save(taskListBDD);
            }

        }


        return taskListBoxremider;
    }


}
