package com.example.EvalChou.repository;

import com.example.EvalChou.model.Task;
import com.example.EvalChou.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
    //methode custom pour recuperé toute les tache une listebox si il sont réalisé ou pas
    @Query("SELECT t FROM Task t WHERE t.realized = :realized and t.task_list_id = :task_list_id ORDER BY t.priority ASC")
    public List<Task> findTaskordebyTaskrealized(@Param("realized")Boolean realized, @Param("task_list_id")TaskList task_list_id);

    //methode custom pour faire un delecte cascade des taches lié a une listebox
    @Query("DELETE FROM Task t WHERE t.task_list_id = :task_list_id ")
    @Transactional
    @Modifying
    public void dellbyTaskListid( @Param("task_list_id")TaskList task_list_id);
}
