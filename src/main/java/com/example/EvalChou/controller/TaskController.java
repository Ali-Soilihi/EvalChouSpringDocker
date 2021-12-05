package com.example.EvalChou.controller;

import com.example.EvalChou.model.Task;
import com.example.EvalChou.repository.TaskRepository;
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


    private static List<Task> tasks = new ArrayList<>();

    @GetMapping("/all")
    public List<Task> getall() {
//      actuelement impossible de cherché les donné en BDD a causse des clé etrangére des table task/tasklist
        tasks = taskRepository.findAll();


        return tasks;
    }

    @PostMapping("/update/{id}/{realized}")
    public Task uspdaterealizedbyid(@PathVariable("id") Integer idtask, @PathVariable("realized") Boolean realized) {

        Task taskRemider = new Task();
//       verification si la tache envoyer dans le post n'est pas en BDD
        /* la ligne suivante crée une exeption qui arret la methode renvoie une erreur */
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            //la methode equals a été overide il prend tous sauf les id avec forenkey inclus
            if (taskBDD.getId().equals(idtask) && !taskBDD.getRealized().equals(realized)) {
                taskRemider = taskBDD;
                taskRemider.setRealized(realized);
                //      enregistrement en BDD
                taskRepository.save(taskRemider);
            }

        }

        if (taskRemider.getRealized() == null) {

            return null;
        }

//        deuxieme requette pour aller chercher le j.son propre et remplis
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            if (taskBDD.equals(taskRemider)) {
//              renvoie du json propre propre et remplis
                return taskBDD;
            }

        }

//      ce retour ser a rien mais au cas ou on aura juste une objet vide
        return taskRemider;
    }

    @PostMapping("/register")
//    ce post enregistre la Task en BDD puis recherche une deuxieme fois dans la bdd et renvoie la tache enregistré
    public Task addTask(@RequestBody Task task) {


//       verification si la tache envoyer dans le post n'est pas en BDD
        /* la ligne suivante crée une exeption qui arret la methode renvoie une erreur */
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            //la methode equals a été overide il prend tous sauf les id avec forenkey inclus
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
//      enregistrement en BDD
        taskRepository.save(task);

//        deuxieme requette pour aller chercher le j.son propre et remplis
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            if (taskBDD.equals(task)) {
//              renvoie du json propre propre et remplis
                return taskBDD;
            }

        }

//      ce retour ser a rien mais au cas ou on aura juste une objet vide
        return task;
    }

}
