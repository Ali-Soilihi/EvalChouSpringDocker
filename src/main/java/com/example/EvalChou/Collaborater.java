package com.example.EvalChou;

import javax.persistence.*;

@Entity
public class Collaborater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String last_name;
    private String first_name;
    private String function;
//    @Transient
//    private TaskList taskList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
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
                "collaboraterId=" + id +
                ", lastName='" + last_name + '\'' +
                ", firstName='" + first_name + '\'' +
                ", function='" + function + '\'' +
                '}';
    }
}
