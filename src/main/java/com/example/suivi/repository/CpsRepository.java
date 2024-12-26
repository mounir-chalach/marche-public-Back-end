package com.example.suivi.repository;

import com.example.suivi.model.Cps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CpsRepository extends JpaRepository<Cps, Integer> {
    @Query("SELECT c FROM Cps c WHERE c.proposePar.id = :utilisateurId")
    List<Cps> findByUtilisateurId(@Param("utilisateurId") int utilisateurId);

    List<Cps> findByProposeParId(int proposeParId);
}
