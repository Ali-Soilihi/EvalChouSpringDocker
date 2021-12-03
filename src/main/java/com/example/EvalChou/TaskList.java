package com.example.EvalChou;

import javax.persistence.*;
import java.util.List;

@Entity
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaskList_id")
    private Integer id;
    @Column(name = "TaskList_Name")
    private String name;
    @OneToMany(targetEntity=Task.class, mappedBy="taskList")
    private List<Task> taskList;

}
