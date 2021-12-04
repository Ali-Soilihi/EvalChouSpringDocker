package com.example.EvalChou;

import javax.persistence.*;
import java.util.List;

@Entity
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskListId")
    private Integer taskListId;
    private String taskListName;
    @OneToMany(fetch = FetchType.LAZY,targetEntity=Task.class, mappedBy= "taskListId")
    private List<Task> taskListBox;

    public Integer getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(Integer taskListId) {
        this.taskListId = taskListId;
    }

    public String getTaskListName() {
        return taskListName;
    }

    public void setTaskListName(String taskListName) {
        this.taskListName = taskListName;
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
                "id=" + taskListId +
                ", name='" + taskListName + '\'' +
                ", taskList=" + taskListBox +
                '}';
    }
}
