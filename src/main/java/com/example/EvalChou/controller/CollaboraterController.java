package com.example.EvalChou.controller;

import com.example.EvalChou.model.Collaborater;
import com.example.EvalChou.model.Task;
import com.example.EvalChou.model.TaskList;
import com.example.EvalChou.repository.CollaboraterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collaborater")
public class CollaboraterController {


    public CollaboraterController(CollaboraterRepository collaboraterRepository) {
        this.collaboraterRepository = collaboraterRepository;
    }

    private CollaboraterRepository collaboraterRepository;

    private static List<Collaborater> collaboraters = new ArrayList<>();

    @GetMapping("/all")
    public List<Collaborater> getall() {

        collaboraters = collaboraterRepository.findAll();


        return collaboraters;
    }

/*todo:8-Je souhaite pouvoir créer ou supprimer un collaborateur (qui a un prénom, un nom, une fonction dans l'entreprise)*/
    @PostMapping("/register")

    public ResponseEntity <Collaborater> addcollaborater(@RequestBody Collaborater collaborater) {

        collaboraters = collaboraterRepository.findAll();
        for (Collaborater collaboraterBDD : collaboraters) {

            if (
                    collaboraterBDD.getFirst_name().equals(collaborater.getFirst_name())
                            &&
                            collaboraterBDD.getLast_name().equals(collaborater.getLast_name())
                            &&
                            collaboraterBDD.getFunction().equals(collaborater.getFunction())

            ) {

                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .header("erreur 409 Conflict", " L'entité est deja en base faut pas faire des doublons comme ça")
                        .build();
            }

        }

        collaboraterRepository.save(collaborater);


        collaboraters = collaboraterRepository.findAll();
        for (Collaborater collaboraterBDD : collaboraters) {
            if (collaboraterBDD.equals(collaborater)) {

               return ResponseEntity.ok(collaboraterBDD);
            }

        }

        return ResponseEntity.ok(collaborater);
    }

/*todo:8-Je souhaite pouvoir créer ou supprimer un collaborateur (qui a un prénom, un nom, une fonction dans l'entreprise)*/
    @PostMapping("/dell/collaboraterid/{collaborater_id}")
    public ResponseEntity <List<Collaborater>> delltaskbyid(@PathVariable("collaborater_id") Integer idcollaborater) {

        boolean findinBDD = false;

        collaboraters = collaboraterRepository.findAll();
        for (Collaborater collaboraterBDD : collaboraters) {

            if (collaboraterBDD.getId().equals(idcollaborater)) {


                findinBDD = true;
                collaboraterRepository.deleteById(idcollaborater);
            }

        }

        if (!findinBDD) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("erreur 404", " L'entité a pas été trouvé en basse désolé")
                    .build();
        }

        collaboraters = collaboraterRepository.findAll();


        return ResponseEntity.ok(collaboraters);
    }


}
