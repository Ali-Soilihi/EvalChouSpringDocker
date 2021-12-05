package com.example.EvalChou.controller;

import com.example.EvalChou.model.Task;
import com.example.EvalChou.model.TaskList;
import com.example.EvalChou.repository.TaskListRepository;
import com.example.EvalChou.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {


    private TaskRepository taskRepository;
    private TaskListRepository taskListRepository;

    public TaskController(TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    private static List<Task> tasks = new ArrayList<>();
    private static List<TaskList> taskLists = new ArrayList<>();

    @GetMapping("/all")
    public List<Task> getall() {
//      actuelement impossible de cherché les donné en BDD a causse des clé etrangére des table task/tasklist
        tasks = taskRepository.findAll();


        return tasks;
    }

    @PostMapping("/dell/taskid/{id}")
    public List<Task> delltaskbyid(@PathVariable("id") Integer idtask) {

        boolean findinBDD=false;
//       verification si la tache envoyer dans le post n'est pas en BDD
        /* la ligne suivante crée une exeption qui arret la methode renvoie une erreur */
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            //la methode equals a été overide il prend tous sauf les id avec forenkey inclus
            if (taskBDD.getId().equals(idtask)) {

                //      enregistrement en BDD
                findinBDD=true;
                taskRepository.deleteById(idtask);
            }

        }

        if (!findinBDD) {

            return null;
        }
//        deuxieme requette pour aller chercher le j.son propre et remplis
        tasks = taskRepository.findAll();


        return tasks;
    }


    @PostMapping("/update/taskid/{id}/title/{title}")
    public Task uspdatetitlebyid(@PathVariable("id") Integer idtask, @PathVariable("title") String title) {

        Task taskRemider = new Task();

        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {

            if (taskBDD.getId().equals(idtask) && !taskBDD.getTitle().equals(title)) {
                taskRemider = taskBDD;
                taskRemider.setTitle(title);

                taskRepository.save(taskRemider);
            }

        }

        if (taskRemider.getTitle() == null) {

            return null;
        }

        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            if (taskBDD.equals(taskRemider)) {

                return taskBDD;
            }

        }


        return taskRemider;
    }

    @PostMapping("/update/taskid/{id}/realized/{realized}")
    public Task uspdaterealizedbyid(@PathVariable("id") Integer idtask, @PathVariable("realized") Boolean realized) {

        Task taskRemider = new Task();

        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {

            if (taskBDD.getId().equals(idtask) && !taskBDD.getRealized().equals(realized)) {
                taskRemider = taskBDD;
                taskRemider.setRealized(realized);

                taskRepository.save(taskRemider);
            }

        }

        if (taskRemider.getRealized() == null) {

            return null;
        }


        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            if (taskBDD.equals(taskRemider)) {

                return taskBDD;
            }

        }


        return taskRemider;
    }

    @PostMapping("/register/{task_list_id}")

    public Task addTask(@RequestBody Task task,@PathVariable("task_list_id") Integer task_list_id) {

         taskLists= taskListRepository.findAll();
        for (TaskList taskListBDD : taskLists) {

            if (taskListBDD.getId().equals(task_list_id)) {
                task.setTask_list_id(taskListBDD);
            }

        }

        if (task.getTask_list_id() == null) {

            return null;
        }


        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {

            if (
                    taskBDD.getTitle().equals(task.getTitle())
                            &&
                            taskBDD.getDescription().equals(task.getDescription())
                            &&
                            taskBDD.getPriority() == task.getPriority()
                            &&
                            taskBDD.getRealized().equals(task.getRealized())
            ) {

                return null;
            }

        }

        taskRepository.save(task);


        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            if (taskBDD.equals(task)) {

                return taskBDD;
            }

        }


        return task;
    }

}
