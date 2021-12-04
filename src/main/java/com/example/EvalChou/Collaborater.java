package com.example.EvalChou;

import javax.persistence.*;

@Entity
public class Collaborater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collaboraterId")
    private Integer collaboraterId;
    private String lastName;
    private String firstName;
    private String function;
//    @Transient
//    private TaskList taskList;

    public Integer getCollaboraterId() {
        return collaboraterId;
    }

    public void setCollaboraterId(Integer collaboraterId) {
        this.collaboraterId = collaboraterId;
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

    @Override
    public String toString() {
        return "Collaborater{" +
                "collaboraterId=" + collaboraterId +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", function='" + function + '\'' +
                '}';
    }
}
