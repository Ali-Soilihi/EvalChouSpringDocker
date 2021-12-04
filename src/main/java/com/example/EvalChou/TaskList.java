package com.example.EvalChou;

import javax.persistence.*;
import java.util.List;

@Entity
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tasklist_id;
    @Column(name = "TaskList_name")
    private String TaskListName;


    @OneToMany(fetch = FetchType.LAZY,targetEntity=Task.class, mappedBy= "tasklist_id")
    private List<Task> task_list_box;

    public Integer getTasklist_id() {
        return tasklist_id;
    }

    public void setTasklist_id(Integer tasklist_id) {
        this.tasklist_id = tasklist_id;
    }

    public String getTaskListName() {
        return TaskListName;
    }

    public void setTaskListName(String taskListName) {
        this.TaskListName = taskListName;
    }

    public List<Task> getTask_list_box() {
        return task_list_box;
    }

    public void setTask_list_box(List<Task> task_list_box) {
        this.task_list_box = task_list_box;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + tasklist_id +
                ", name='" + TaskListName + '\'' +
                ", taskList=" + task_list_box +
                '}';
    }
}
