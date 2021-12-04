package com.example.EvalChou;

import javax.persistence.*;

@Entity
public class Collaborater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer collaborater_id;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    private String function;
    @Transient
    private TaskList taskList;

    public Integer getCollaborater_id() {
        return collaborater_id;
    }

    public void setCollaborater_id(Integer collaborater_id) {
        this.collaborater_id = collaborater_id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "Collaborater{" +
                "id=" + collaborater_id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", function='" + function + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
