package com.example.suivi.service;

import com.example.suivi.model.Cps;
import com.example.suivi.model.CpsDTO;
import com.example.suivi.model.Projet;
import com.example.suivi.model.Utilisateur;
import com.example.suivi.repository.CpsRepository;
import com.example.suivi.repository.ProjetRepository;
import com.example.suivi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class CpsService {

    @Autowired
    private CpsRepository cpsRepository;

    @Autowired
    private ProjetRepository projetRepository;

    @Autowired UtilisateurRepository utiliseurRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public List<Cps> getCpsByUserId(int userId) {
        return cpsRepository.findByProposeParId(userId);
    }

    public void addCps(CpsDTO cpsDTO) {
        Cps cps = new Cps();

        // Map basic fields from DTO to entity
        cps.setNom(cpsDTO.getNom());
        cps.setTasks(cpsDTO.getTasks());
cps.setStack(cpsDTO.getStack());
        // Retrieve and set associated project
        Optional<Projet> project = projetRepository.findById(cpsDTO.getProjectId());
        if (project.isPresent()) {
            cps.setProject_id(project.get());
        } else {
            throw new RuntimeException("Project with ID " + cpsDTO.getProjectId() + " not found.");
        }

        // Set the user (proposeParId)
        Optional<Utilisateur> user = utilisateurRepository.findById(cpsDTO.getProposeParId());
        if (user.isPresent()) {
            cps.setproposePar(user.get());
        } else {
            throw new RuntimeException("User with ID " + cpsDTO.getProposeParId() + " not found.");
        }

        // Save the CPS entity
        cpsRepository.save(cps);
    }


    @Transactional
    public void deleteCPSById(int id) {
        if (!cpsRepository.existsById(id)) {
            throw new IllegalArgumentException("CPS with ID " + id + " does not exist.");
        }
        cpsRepository.deleteById(id);
    }
}




