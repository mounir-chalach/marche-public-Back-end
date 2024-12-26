package com.example.suivi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.suivi.model.Utilisateur;

@Repository
public interface CustomerRepository extends JpaRepository<Utilisateur, Long> {
    boolean existsByEmail(String email);

    Optional<Utilisateur> findByEmail(String email);
}
