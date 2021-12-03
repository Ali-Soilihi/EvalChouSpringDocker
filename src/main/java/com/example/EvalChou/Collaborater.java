package com.example.EvalChou;

import javax.persistence.*;

@Entity
public class Collaborater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Collaborater_id")
    private Integer id;
    private String lastName;
    private String firstName;
    private String function;
    @Transient
    private TaskList taskList;


}
