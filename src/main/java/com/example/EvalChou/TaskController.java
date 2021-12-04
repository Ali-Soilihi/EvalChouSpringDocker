package com.example.EvalChou;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    private TaskRepository taskRepository;


    private static List<Task> tasks=new ArrayList<>();

    @GetMapping("/all")
    public List<Task> getall(){
//      actuelement impossible de cherché les donné en BDD a causse des clé etrangére des table task/tasklist
        tasks=taskRepository.findAll();


        return tasks;
    }

    @PostMapping("/register")
//    ce post enregistre la Task en BDD puis recherche une deuxieme fois dans la bdd et renvoie la tache enregistré
    public Task addTask( @RequestBody Task task){


//       verification si la tache envoyer dans le post n'est pas en BDD
        /* la ligne suivante crée une exeption qui arret la methode renvoie une erreur */
        tasks=taskRepository.findAll();
        for(Task taskBDD:tasks){
            //la methode equals a été overide il prend tous sauf les id avec forenkey inclus
            if(taskBDD.equals(task)){

                return  null;
            }

        }
//      enregistrement en BDD
        taskRepository.save(task);

//        deuxieme requette pour aller chercher le j.son propre et remplis
        tasks=taskRepository.findAll();
        for(Task taskBDD:tasks){
            if(taskBDD.equals(task)){
//              renvoie du json propre propre et remplis
                return taskBDD;
            }

        }

//      ce retour ser a rien mais au cas ou on aura juste une objet vide
        return task;
    }

}
