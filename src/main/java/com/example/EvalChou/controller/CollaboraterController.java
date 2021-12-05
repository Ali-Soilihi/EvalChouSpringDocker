package com.example.EvalChou.controller;

import com.example.EvalChou.model.Collaborater;
import com.example.EvalChou.model.Task;
import com.example.EvalChou.model.TaskList;
import com.example.EvalChou.repository.CollaboraterRepository;
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

    public Collaborater addcollaborater(@RequestBody Collaborater collaborater) {

        collaboraters = collaboraterRepository.findAll();
        for (Collaborater collaboraterBDD : collaboraters) {

            if (
                    collaboraterBDD.getFirst_name().equals(collaborater.getFirst_name())
                            &&
                            collaboraterBDD.getLast_name().equals(collaborater.getLast_name())
                            &&
                            collaboraterBDD.getFunction().equals(collaborater.getFunction())

            ) {

                return null;
            }

        }

        collaboraterRepository.save(collaborater);


        collaboraters = collaboraterRepository.findAll();
        for (Collaborater collaboraterBDD : collaboraters) {
            if (collaboraterBDD.equals(collaborater)) {

                return collaboraterBDD;
            }

        }


        return collaborater;
    }

/*todo:8-Je souhaite pouvoir créer ou supprimer un collaborateur (qui a un prénom, un nom, une fonction dans l'entreprise)*/
    @PostMapping("/dell/collaboraterid/{collaborater_id}")
    public List<Collaborater> delltaskbyid(@PathVariable("id") Integer idcollaborater) {

        boolean findinBDD = false;

        collaboraters = collaboraterRepository.findAll();
        for (Collaborater collaboraterBDD : collaboraters) {

            if (collaboraterBDD.getId().equals(idcollaborater)) {


                findinBDD = true;
                collaboraterRepository.deleteById(idcollaborater);
            }

        }

        if (!findinBDD) {

            return null;
        }

        collaboraters = collaboraterRepository.findAll();


        return collaboraters;
    }


}
