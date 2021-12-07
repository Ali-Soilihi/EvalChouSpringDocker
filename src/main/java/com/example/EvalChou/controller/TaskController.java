package com.example.EvalChou.controller;

import com.example.EvalChou.model.Collaborater;
import com.example.EvalChou.model.Task;
import com.example.EvalChou.model.TaskList;
import com.example.EvalChou.repository.CollaboraterRepository;
import com.example.EvalChou.repository.TaskListRepository;
import com.example.EvalChou.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {


    private CollaboraterRepository collaboraterRepository;

    public TaskController(CollaboraterRepository collaboraterRepository, TaskRepository taskRepository, TaskListRepository taskListRepository) {
        this.collaboraterRepository = collaboraterRepository;
        this.taskRepository = taskRepository;
        this.taskListRepository = taskListRepository;
    }

    private TaskRepository taskRepository;
    private TaskListRepository taskListRepository;


    private static List<Collaborater> collaboraters = new ArrayList<>();
    private static List<Task> tasks = new ArrayList<>();
    private static List<TaskList> taskLists = new ArrayList<>();

    @GetMapping("/all")
    public List<Task> getall() {

        tasks = taskRepository.findAll();


        return tasks;
    }


    /*todo:2-Je veux pouvoir créer une tâche dans la liste avec un intitulé, une description, une priorité (HAUTE, MOYENNE, BASSE) et indiqué si elle est réalisée ou non.*/
    // /!\ une tache dois forcement etre lié a une id de task list(sa forenkey) donné dans l'url sinon il renvoie null
    @PostMapping("/register/{task_list_id}")
    /** créé la tache avec sont id de forenkey en parametre **/
    public ResponseEntity <Task> addTask(@RequestBody Task task, @PathVariable("task_list_id") Integer task_list_id) {
//       pour sauvegarder la tasklist lié a l'id en parametre
        taskLists = taskListRepository.findAll();
        for (TaskList taskListBDD : taskLists) {
//          si il y'a une tasklist en BDD qui est a la même id que celle en parametre alors:
            if (taskListBDD.getId().equals(task_list_id)) {

                taskListBDD.getTaskListBox().add(task);

                taskListRepository.save(taskListBDD);

                task.setTask_list_id(taskListBDD);
            }

        }
//       si la forenkey dans task est toujour null donc aucune tasklit na été trouvé renvois null
        if (task.getTask_list_id() == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("erreur 404", " L'entité \"tasklist\" a pas été trouvé en basse désolé")
                    .build();
        }

//      tasklit ok maitenant on regarde en BDD si la task est deja presente si c'est le cas renvoie err 409
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
//          verifie tous les atribue sauf forenkey et id
            if (
                    taskBDD.getTitle().equals(task.getTitle())
                            &&
                            taskBDD.getDescription().equals(task.getDescription())
                            &&
                            taskBDD.getPriority() == task.getPriority()
                            &&
                            taskBDD.getRealized().equals(task.getRealized())
            ) {

                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .header("erreur 409 Conflict", " L'entité est deja en base faut pas faire des doublons comme ça")
                        .build();
            }

        }
//       save en bdd
        taskRepository.save(task);

//     recherche une deuxieme fois pour affiché un objet propre
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            if (taskBDD.equals(task)) {

                return ResponseEntity.ok(taskBDD);

            }

        }

//        retour qui ser a rien mais au pire des cas renvois un objet vide
        return ResponseEntity.ok(task);
    }
    /*todo: 3-Je veux pouvoir indiquer qu'une tâche a été réalisée, ou au contraire, qu'une tâche réalisée ne l'est finalement pas.*/
    @PostMapping("/update/taskid/{id}/realized/{realized}")
    /** met a jour la réalisation de la tache attention si la variable (realized)
     * n'est pas un boulééen true ou false en toute lettre vous aurais une erreur **/
    public ResponseEntity <Task> uspdaterealizedbyid(@PathVariable("id") Integer idtask, @PathVariable("realized") Boolean realized) {

        Task taskRemider = new Task();
        //pour sauvegarder la tache lié a l'id en parametre et met a jour sa "realisation"
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
//          si l'idée en parametre est bonne et si la réalisation en BDD et differente de celle en parametre
            if (taskBDD.getId().equals(idtask) && !taskBDD.getRealized().equals(realized)) {

                taskRemider=taskBDD;
                taskBDD.setRealized(realized);

                taskRepository.save(taskBDD);
            }

        }

//      si sa réalisation est la même qu'en parametre renvoie null
        if (taskRemider.getRealized() != realized) {

            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .header("erreur 409 Conflict", " L'entité est deja a cette valeur en base faut pas faire des doublons comme ça")
                    .build();
        }

//      recherche une deuxieme fois pour affiché un objet propre
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            if (taskBDD.getId().equals(idtask)) {

                return ResponseEntity.ok(taskBDD);

            }

        }

//      retour qui ser a rien mais au pire des cas renvois un objet vide
        return ResponseEntity.ok(taskRemider);
    }

    /*todo:4-Je veux pouvoir mettre à jour l'intitulé et la description d'une tâche.*/
    @PostMapping("/update/taskid/{id}/title/{title}")
    public ResponseEntity <Task> uspdatetitlebyid(@PathVariable("id") Integer idtask, @PathVariable("title") String title) {


        Task taskRemider = new Task();

        //pour sauvegarder la tache lié a l'id en parametre
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
//          si l'id en parametre est bonne et si le titre en BDD et differente de celle en parametre
            if (taskBDD.getId().equals(idtask) && !taskBDD.getTitle().equals(title)) {
                taskRemider = taskBDD;
                taskRemider.setTitle(title);

                taskRepository.save(taskRemider);
            }

        }
//      renvois null si aucun objet en BDD n'est lié au titre donné en parametre
        if (taskRemider.getTitle() == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("erreur 404", " L'entité a pas été trouvé en basse désolé")
                    .build();
        }
//      recherche une deuxieme fois pour affiché un objet propre
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            if (taskBDD.equals(taskRemider)) {

                return ResponseEntity.ok(taskBDD);
            }

        }

//      retour qui ser a rien mais au pire des cas renvois un objet vide
        return ResponseEntity.ok(taskRemider);
    }

    /*todo: 5-Je veux pouvoir supprimer une tâche.*/
    @PostMapping("/dell/taskid/{id}")
    public ResponseEntity <List<Task>> delltaskbyid(@PathVariable("id") Integer idtask) {

        boolean findinBDD = false;
//      recherche la tache si elle est en BDD la suprime
        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {

            if (taskBDD.getId().equals(idtask)) {
                findinBDD = true;
                taskRepository.deleteById(idtask);
            }

        }
// si aucune tache n'est trouvé renvoie null
        if (!findinBDD) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).varyBy("L'entité a pas été trouvé en basse désolé").build();
        }
//      suite recherché puis renvoyer la liste des tache sans celle qui viens d'etre suprimé
        tasks = taskRepository.findAll();


        return ResponseEntity.ok(tasks);
    }

    /*todo:9-Je souhaite pouvoir assigner la tâche à un collaborateur ou à l'inverse indiquer qu'elle n'est assignée à personne*/
    @PostMapping("/update/taskid/{id}/collaborater/{collaborater_id}")
    /** assigne une tache a un collaborateur **/
    public ResponseEntity <Task> uspdatecollaboraterbyid(@PathVariable("id") Integer idtask, @PathVariable("collaborater_id") Integer idcollaborater) {

        boolean updateIsOk = false;
        Task taskRemider=new Task();
        Collaborater collaboraterRemider = new Collaborater();

        collaboraters = collaboraterRepository.findAll();
        for (Collaborater collaboraterBDD : collaboraters) {

            if (collaboraterBDD.getId().equals(idcollaborater)) {
                collaboraterRemider = collaboraterBDD;
            }

        }

        if (collaboraterRemider.getId() == null) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("erreur 404", " L'entité \"collaborater\" a pas été trouvé en basse désolé")
                    .build();
        }

        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {

            if (taskBDD.getId().equals(idtask) && !taskBDD.getCollaborater_id().getId().equals(collaboraterRemider.getId())) {

                taskRemider=taskBDD;
                taskBDD.setCollaborater_id(collaboraterRemider);
                taskRepository.save(taskBDD);
                updateIsOk = true;

            }

        }

        if (!updateIsOk) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("erreur 404", " L'entité \"tache\" deja assigné à ce \"collaborater\" ou n'est pas en base ")
                    .build();
        }


        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            if (taskBDD.equals(taskRemider)) {

                return ResponseEntity.ok(taskBDD);
            }

        }


        return  ResponseEntity.ok(taskRemider);
    }



    /*todo:9-Je souhaite pouvoir assigner la tâche à un collaborateur ou à l'inverse indiquer qu'elle n'est assignée à personne*/
    @PostMapping("/update/taskid/{id}/collaborater/null")
    /** assigne une tache a un personne (null) **/
    public ResponseEntity <Task> uspdatetasknull(@PathVariable("id") Integer idtask) {
        boolean updateIsOk = false;
        Task taskRemider=new Task();

        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {

            if (taskBDD.getId().equals(idtask) && taskBDD.getCollaborater_id()!=null) {
                taskBDD.setCollaborater_id(null);
                taskRepository.save(taskBDD);
                updateIsOk = true;

            }

        }

        if (!updateIsOk) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("erreur 404", " L'entité \"tache\" deja assigné à personne(null) ou n'est pas en base ")
                    .build();
        }


        tasks = taskRepository.findAll();
        for (Task taskBDD : tasks) {
            if (taskBDD.getId().equals(idtask)) {

                return ResponseEntity.ok(taskBDD);
            }

        }


        return  ResponseEntity.ok(taskRemider);
    }



}
