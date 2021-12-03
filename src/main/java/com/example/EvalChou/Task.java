package com.example.EvalChou;

import javax.persistence.*;
import java.util.List;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Task_id")
    private Integer id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private Boolean realized;

    @ManyToOne
    @JoinColumn(name = "TaskList_id")
    private TaskList taskList;

    @OneToOne
    @JoinColumn(name = "Collaborater_id")
    private Collaborater collaborater;
}
