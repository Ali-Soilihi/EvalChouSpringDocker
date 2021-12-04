package com.example.EvalChou;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskId")
    private Integer taskId;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    private Boolean realized;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taskListId")
    private TaskList taskListId;
    @OneToOne
    @JoinColumn(name = "collaboraterId")
    private Collaborater collaboraterId;

    //overide equals pour prendre en compte tous sauf les id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return title.equals(task.title) && description.equals(task.description) && priority == task.priority && realized.equals(task.realized);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, priority, realized);
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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

    public TaskList getTaskListId() {
        return taskListId;
    }

    public void setTaskListId(TaskList taskListId) {
        this.taskListId = taskListId;
    }

    public Collaborater getCollaboraterId() {
        return collaboraterId;
    }

    public void setCollaboraterId(Collaborater collaboraterId) {
        this.collaboraterId = collaboraterId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority +
                ", realized=" + realized +
                ", taskList=" + taskListId +
                ", collaborater=" + collaboraterId +
                '}';
    }


}
