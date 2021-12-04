package com.example.EvalChou;

import javax.persistence.*;
import java.util.List;

@Entity
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaskList_id")
    private Integer id;
    @Column(name = "TaskList_name")
    private String TaskListName;
    @OneToMany(targetEntity=Task.class, mappedBy= "tasklist_id")
    private List<Task> tasks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskListName() {
        return TaskListName;
    }

    public void setTaskListName(String taskListName) {
        this.TaskListName = taskListName;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", name='" + TaskListName + '\'' +
                ", taskList=" + tasks +
                '}';
    }
}
