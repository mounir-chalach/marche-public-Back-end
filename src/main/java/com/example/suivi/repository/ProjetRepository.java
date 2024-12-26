package com.example.suivi.repository;

import com.example.suivi.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Integer> {
    @Query("SELECT p FROM Projet p")
    List<Projet> fetchAll();
    List<Projet> findByProposeParId(int userId);
}
