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

    @PostMapping("/register")
//    ce post enregistre la TaskList en BDD puis recherche une deuxieme fois dans la bdd et renvoie la liste enregistré
    public TaskList addTasklist(@RequestBody TaskList taskList){

//       verification si la liste envoyer dans le post n'est pas en BDD
        /* la ligne suivante crée une exeption qui arret l'application*/
        taskLists=taskListRepository.findAll();
        for(TaskList tasklistBDD:taskLists){
            if(tasklistBDD.getTaskListName().equals(taskList.getTaskListName())){

                return  null;
            }

        }
//      enregistrement en BDD
        taskListRepository.save(taskList);

//        deuxieme requette pour aller chercher le j.son propre et remplis
        taskLists=taskListRepository.findAll();
        for(TaskList tasklistBDD:taskLists){
            if(tasklistBDD.getTaskListName().equals(taskList.getTaskListName())){
//              renvoie du json propre propre et remplis
               return tasklistBDD;
            }

        }

//      ce retour ser a rien mais au cas ou on aura juste une liste vide
        return taskList;
    }

}
