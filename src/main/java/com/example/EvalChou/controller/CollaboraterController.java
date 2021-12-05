package com.example.EvalChou.controller;

import com.example.EvalChou.model.Collaborater;
import com.example.EvalChou.repository.CollaboraterRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/collaborater")
public class CollaboraterController {


    public CollaboraterController(CollaboraterRepository collaboraterRepository) {
        this.collaboraterRepository = collaboraterRepository;
    }

    private CollaboraterRepository collaboraterRepository;

    private static List<Collaborater> collaboraters=new ArrayList<>();

    @GetMapping("/all")
    public List<Collaborater> getall(){

        collaboraters=collaboraterRepository.findAll();


        return collaboraters;
    }



}
