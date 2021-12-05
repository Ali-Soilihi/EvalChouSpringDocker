package com.example.EvalChou.repository;

import com.example.EvalChou.model.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList,Integer> {
}