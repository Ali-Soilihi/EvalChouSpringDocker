package com.example.EvalChou.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private Boolean realized;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taskListId")
    @JsonIgnore
    private TaskList task_list_id;
    @OneToOne
    @JoinColumn(name = "collaborater_id")
    private Collaborater collaborater_id;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Boolean getRealized() {
        return realized;
    }

    public void setRealized(Boolean realized) {
        this.realized = realized;
    }

    public TaskList getTask_list_id() {
        return task_list_id;
    }

    public void setTask_list_id(TaskList task_list_id) {
        this.task_list_id = task_list_id;
    }

    public Collaborater getCollaborater_id() {
        return collaborater_id;
    }

    public void setCollaborater_id(Collaborater collaborater_id) {
        this.collaborater_id = collaborater_id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", realized=" + realized +
                ", task_list_id=" + task_list_id +
                ", collaborater_id=" + collaborater_id +
                '}';
    }
}
