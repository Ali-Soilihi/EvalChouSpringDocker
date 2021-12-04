package com.example.EvalChou;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String task_list_name;
    @OneToMany(fetch = FetchType.LAZY,targetEntity=Task.class, mappedBy= "id")
    @JsonIgnore
    private List<Task> taskListBox;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTask_list_name() {
        return task_list_name;
    }

    public void setTask_list_name(String task_list_name) {
        this.task_list_name = task_list_name;
    }

    public List<Task> getTaskListBox() {
        return taskListBox;
    }

    public void setTaskListBox(List<Task> taskListBox) {
        this.taskListBox = taskListBox;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", name='" + task_list_name + '\'' +
                ", taskList=" + taskListBox +
                '}';
    }
}
