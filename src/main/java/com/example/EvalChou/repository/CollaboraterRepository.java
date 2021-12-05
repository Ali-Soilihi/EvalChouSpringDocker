package com.example.EvalChou.repository;

import com.example.EvalChou.model.Collaborater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboraterRepository extends JpaRepository<Collaborater,Integer> {
}
