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
    public ResponseEntity <TaskList> addTasklist(@RequestBody TaskList taskList) {

//      recherche le nom de la liste si deja presente dans la bdd reponse http
        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {
            if (tasklistBDD.getTask_list_name().equals(taskList.getTask_list_name())) {

                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .header("erreur 404", " L'entité a pas été trouvé en basse désolé")
                        .build();
            }

        }
//      enregistre dans la bdd
        taskListRepository.save(taskList);

//      recherche une deuxieme fois pour affiché un objet propre
        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {
            if (tasklistBDD.getTask_list_name().equals(taskList.getTask_list_name())) {

                return ResponseEntity.ok(tasklistBDD);
            }

        }

//      retour qui sert a rien mais au pire des cas renvois un objet vide
        return ResponseEntity.ok(taskList);
    }

/*todo:6-Je veux pouvoir récupérer toutes les tâches d'une liste donnée en paramètre, triées dans l'ordre de priorité,
   avec un paramètre me permettant de dire si je veux également les tâches réalisées*/
/** ici on ordonne par priorité et si "realisé" ou pas  **/
    @GetMapping("{id}/taskListBox/all/realized/{realized}")
    public ResponseEntity <List<Task>> gettaskListBoxOrderbyrealised(@PathVariable("id") Integer idtaskList,@PathVariable("realized") boolean realized) {
        TaskList taskListremider = new TaskList();
        List<Task> taskListOrder = new ArrayList<>();

//      recherche dans la BDD la bonne list de tache
        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {
            if (tasklistBDD.getId().equals(idtaskList)) {
                taskListremider = tasklistBDD;
            }
        }

//      3 boucle pour les ranger
        tasks = taskRepository.findTaskordebyTaskrealized(realized,taskListremider);//methode custom pour recuperé toute les tache une listebox si il sont réalisé ou pas
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

//      retour de la liste trié
        return ResponseEntity.ok(taskListOrder);

    }

/*todo:6-Je veux pouvoir récupérer toutes les tâches d'une liste donnée en paramètre, triées dans l'ordre de priorité,
   avec un paramètre me permettant de dire si je veux également les tâches réalisées*/
    /** ici on affiche tous les tache d'une tache list **/
    @GetMapping("{id}/taskListBox/all")
    public ResponseEntity  <List<Task>> gettaskListBox(@PathVariable("id") Integer idtaskList) {
        List<Task> taskListBoxremider = new ArrayList<>();
//      recherche la box de liste et l'affiche
        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {
            if (tasklistBDD.getId().equals(idtaskList)) {
                taskListBoxremider = tasklistBDD.getTaskListBox();
            }

        }
//      retour http et l'entité
        return ResponseEntity.ok(taskListBoxremider);
    }
    /*todo:7-Je veux pouvoir supprimer une liste de tâches. Si la liste n'est pas vide, je vous laisse le choix :
       supprimer la liste et toutes les tâches associées, ou renvoyer un message avec une erreur 400 "La liste doit être vide avant d'être supprimée".*/
    @PostMapping("/dell/tasklistid/{id}")
    /** suprime la liste de tache seulement si elle est vide **/
    public ResponseEntity <List<TaskList>> delltaskListbyid(@PathVariable("id") Integer idtaskList) {

        List<Task> taskListBoxremider = new ArrayList<>();
        boolean findinBDD = false;

//      recherche la tachelist et ces tache lié si elle est en BDD les suprime tous
        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {
            if (tasklistBDD.getId().equals(idtaskList)) {
                taskListBoxremider = tasklistBDD.getTaskListBox();
            }

        }
//      la verification si la liste est vide
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

                taskRepository.dellbyTaskListid(tasklistBDD);//methode custom pour faire un delecte cascade des taches lié a une listebox
                taskListRepository.deleteById(idtaskList);
            }

        }

        //regarde la reponse http
        if (!findinBDD) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("erreur 404", "L'entité a pas été trouvé en basse désolé")
                    .build();

        }

        taskLists = taskListRepository.findAll();

        //retour de la table sans celle qui est suprimé
        return ResponseEntity.ok(taskLists);
    }
    /*todo:7-Je veux pouvoir supprimer une liste de tâches. Si la liste n'est pas vide, je vous laisse le choix :
       supprimer la liste et toutes les tâches associées, ou renvoyer un message avec une erreur 400 "La liste doit être vide avant d'être supprimée".*/
    @PostMapping("/dell/tasklistid/{id}/force")
    /** suprimé sans verification **/
    public ResponseEntity <List<TaskList>> delltaskListbyidforce(@PathVariable("id") Integer idtaskList) {

        boolean findinBDD = false;

//      recherche la tachelist et ces tache lié si elle est en BDD les suprime tous
        taskLists = taskListRepository.findAll();
        for (TaskList tasklistBDD : taskLists) {

            if (tasklistBDD.getId().equals(idtaskList)) {
                findinBDD = true;

                taskRepository.dellbyTaskListid(tasklistBDD);//methode custom pour faire un delecte cascade des taches lié a une listebox
                taskListRepository.deleteById(idtaskList);
            }

        }
//      la verification si la liste est vide
        if (!findinBDD) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("erreur 404", " L'entité a pas été trouvé en basse désolé")
                    .build();

        }

        taskLists = taskListRepository.findAll();

        //retour de la table sans celle qui est suprimé
        return ResponseEntity.ok(taskLists);
    }

/** les methode suivante n'on pas été demander dans les question **/

    @PutMapping("{id}/taskListBox/update/task/{idtask}")
    /** lie une liste avec l'entité tasklist (je commente pas trop vus que c'est pas demander) **/
    public ResponseEntity <List<Task>> addtaskintaskListBox(@PathVariable("id") Integer idtaskList, @PathVariable("idtask") Integer idtask) {
        Task taskRemider = new Task();
        List<Task> taskListBoxremider = new ArrayList<>();

        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {

            if (taskBDD.getId().equals(idtask)) {
                taskRemider = taskBDD;
            }

        }

        if (taskRemider.getId() == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("erreur 404", " L'entité a pas été trouvé en basse désolé")
                    .build();

        }

        taskLists = taskListRepository.findAll();
        for (TaskList taskListBDD : taskLists) {

            if (taskListBDD.getId().equals(idtaskList)) {
                if (taskListBDD.getTaskListBox().contains(taskRemider)) {

                    return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .header("erreur 404", " L'entité \"tache\" deja assigné à cette liste de tache ")
                            .build();
                }
                taskListBoxremider = taskListBDD.getTaskListBox();

                taskListBoxremider.add(taskRemider);

                taskListBDD.setTaskListBox(taskListBoxremider);

                taskRemider.setTask_list_id(taskListBDD);

                taskRepository.save(taskRemider);
                taskListRepository.save(taskListBDD);
            }

        }

        return ResponseEntity.ok(taskListBoxremider);
    }


}
