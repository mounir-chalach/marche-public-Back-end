package com.example.suivi.service;

import com.example.suivi.model.Projet;
import com.example.suivi.model.ProjetDTO;
import com.example.suivi.model.Utilisateur;
import com.example.suivi.model.UtilisateurDTO;
import com.example.suivi.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class ProjetService {
@Autowired
    private final ProjetRepository projetRepository;
@Autowired
private final UtilisateurService utilisateurService;

    public ProjetService(ProjetRepository projetRepository, UtilisateurService utilisateurService) {
        this.projetRepository = projetRepository;
        this.utilisateurService = utilisateurService;
    }

    @Transactional
    public List<Projet> getAllProjects() {
        return projetRepository.fetchAll();
    }

public Projet approveProject(int id) {
    Projet projet = projetRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
    projet.setApproved(Boolean.TRUE);
    return projetRepository.save(projet);
}

    public Projet disApproveProject(int id) {
        Projet projet = projetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
        projet.setApproved(Boolean.FALSE);
        return projetRepository.save(projet);
    }

    @Transactional
    public void addProject(ProjetDTO projetDTO) {
        // Create the Projet entity
        Projet projet = new Projet();
        projet.setTitre(projetDTO.getTitre());
        projet.setBudget(projetDTO.getBudget());
        projet.setDateDebut(projetDTO.getDateDebut());
        projet.setDateFin(projetDTO.getDateFin());

        // Retrieve the proposePar (Utilisateur) by name
        Utilisateur proposePar = utilisateurService.findByName(projetDTO.getProposeParNom());  // Find by name

        if (proposePar == null) {
            throw new RuntimeException("User with name " + projetDTO.getProposeParNom() + " not found");
        }

        // Set proposePar to the project (Many-to-One relationship)
        projet.setProposePar(proposePar);

        // Save the project
        projetRepository.save(projet);
    }
@Transactional
public List<Projet> getProjectsById(int id) {
       return projetRepository.findByProposeParId(id);
}

}