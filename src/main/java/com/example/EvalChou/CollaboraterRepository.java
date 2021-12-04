package com.example.EvalChou;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollaboraterRepository extends JpaRepository<Collaborater,Integer> {
}
