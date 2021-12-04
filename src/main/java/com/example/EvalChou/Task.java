package com.example.EvalChou;

import javax.persistence.*;

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
    @JoinColumn(name = "tasklist_id")
    private TaskList tasklist_id;

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

    public TaskList getTasklist_id() {
        return tasklist_id;
    }

    public void setTasklist_id(TaskList tasklist_id) {
        this.tasklist_id = tasklist_id;
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
                ", taskList=" + tasklist_id +
                ", collaborater=" + collaborater_id +
                '}';
    }
}
