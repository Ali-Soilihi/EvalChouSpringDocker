package com.example.EvalChou.model;

import javax.persistence.*;

@Entity
public class Collaborater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String last_name;
    private String first_name;
    private String function;

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

//    @Override
//    public String toString() {
//        return "Collaborater{" +
//                "id=" + id +
//                ", last_name='" + last_name + '\'' +
//                ", first_name='" + first_name + '\'' +
//                ", function='" + function + '\'' +
//                '}';
//    }
}
