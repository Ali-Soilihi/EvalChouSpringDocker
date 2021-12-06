package com.example.EvalChou.controller;


import com.example.EvalChou.model.Task;
import com.example.EvalChou.model.TaskList;
import com.example.EvalChou.repository.TaskListRepository;
import com.example.EvalChou.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

/*todo:6-Je veux pouvoir récupérer toutes les tâches d'une liste donnée en paramètre, triées dans l'ordre de priorité,
   avec un paramètre me permettant de dire si je veux également les tâches réalisées*/
/** ici on ordonne par priorité et si "realisé" ou pas  **/
    @GetMapping("{id}/taskListBox/all/realized/{realized}")
    public List<Task> gettaskListBoxOrderbyrealised(@PathVariable("id") Integer idtaskList,@PathVariable("realized") boolean realized) {
        TaskList taskListremider = new TaskList();
        List<Task> taskListOrder = new ArrayList<>();

        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {
            if (tasklistBDD.getId().equals(idtaskList)) {
                taskListremider = tasklistBDD;
            }
        }

        tasks = taskRepository.findTaskordebyTaskrealized(realized,taskListremider);
        for (Task taskBDD : tasks) {
            if (taskBDD.getPriority().toString().equals("HIGH")) {
                taskListOrder.add(taskBDD);
            }
        }
        for (Task taskBDD : tasks) {
            if (taskBDD.getPriority().toString().equals("MEDIUM")) {
                taskListOrder.add(taskBDD);
            }
        }
        for (Task taskBDD : tasks) {
            if (taskBDD.getPriority().toString().equals("LOW")) {
                taskListOrder.add(taskBDD);
            }
        }


        return taskListOrder;
    }

/*todo:6-Je veux pouvoir récupérer toutes les tâches d'une liste donnée en paramètre, triées dans l'ordre de priorité,
   avec un paramètre me permettant de dire si je veux également les tâches réalisées*/
    /** ici on affiche tous les tache d'une tache list **/
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
    /*todo:7-Je veux pouvoir supprimer une liste de tâches. Si la liste n'est pas vide, je vous laisse le choix :
       supprimer la liste et toutes les tâches associées, ou renvoyer un message avec une erreur 400 "La liste doit être vide avant d'être supprimée".*/
    @PostMapping("/dell/tasklistid/{id}")
    public ResponseEntity<List<TaskList>> delltaskListbyid(@PathVariable("id") Integer idtaskList) {

        List<Task> taskListBoxremider = new ArrayList<>();
        boolean findinBDD = false;

        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {
            if (tasklistBDD.getId().equals(idtaskList)) {
                taskListBoxremider = tasklistBDD.getTaskListBox();
            }

        }

        if (taskListBoxremider.size()!=0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .header("erreur 400", " La liste doit être vide avant d'être supprimée ")
                    .build();
        }

//      recherche la tache si elle est en BDD la suprime
        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {

            if (tasklistBDD.getId().equals(idtaskList)) {
                findinBDD = true;

                taskRepository.dellbyTaskListid(tasklistBDD);
                taskListRepository.deleteById(idtaskList);
            }

        }

        if (!findinBDD) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("erreur 404", "L'entité a pas été trouvé en basse désolé")
                    .build();

        }

        taskLists = taskListRepository.findAll();


        return ResponseEntity.ok(taskLists);
    }
    /*todo:7-Je veux pouvoir supprimer une liste de tâches. Si la liste n'est pas vide, je vous laisse le choix :
       supprimer la liste et toutes les tâches associées, ou renvoyer un message avec une erreur 400 "La liste doit être vide avant d'être supprimée".*/
    @PostMapping("/dell/tasklistid/{id}/force")
    public ResponseEntity<List<TaskList>> delltaskListbyidforce(@PathVariable("id") Integer idtaskList) {

        boolean findinBDD = false;

//      recherche la tachelist et ces tache lié si elle est en BDD les suprime tous
        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {

            if (tasklistBDD.getId().equals(idtaskList)) {
                findinBDD = true;

                taskRepository.dellbyTaskListid(tasklistBDD);
                taskListRepository.deleteById(idtaskList);
            }

        }

        if (!findinBDD) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("erreur 404", " L'entité a pas été trouvé en basse désolé")
                    .build();

        }

        taskLists = taskListRepository.findAll();


        return ResponseEntity.ok(taskLists);
    }

/** les methode suivante n'on pas été demander dans les question **/

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
