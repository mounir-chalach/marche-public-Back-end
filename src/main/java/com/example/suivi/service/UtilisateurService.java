package com.example.suivi.service;

import com.example.suivi.model.Projet;
import com.example.suivi.model.Utilisateur;
import com.example.suivi.model.UtilisateurDTO;
import com.example.suivi.repository.ProjetRepository;
import com.example.suivi.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UtilisateurService {
@Autowired
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }


    public List<Utilisateur> getAllUsers() {
        return utilisateurRepository.findAll();
    }

    @Transactional
    public void deleteUserById(int id) {
        if (!utilisateurRepository.existsById(id)) {
            throw new IllegalArgumentException("User with ID " + id + " does not exist.");
        }
        utilisateurRepository.deleteById(id);
    }

@Transactional
        public void addUser(UtilisateurDTO utilisateurDTO) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setNom(utilisateurDTO.getNom());
            utilisateur.setEmail(utilisateurDTO.getEmail());
            utilisateur.setPassword(utilisateurDTO.getPassword());
            utilisateur.setGsm(utilisateurDTO.getGsm());
            utilisateur.setType(utilisateurDTO.getType());
    utilisateurRepository.save(utilisateur);
        }
    public UtilisateurDTO findByEmailAndPassword(String email, String password) {
        Optional<Utilisateur> utilisateurOpt = utilisateurRepository.findByEmail(email);
        if (utilisateurOpt.isPresent()) {
            Utilisateur utilisateur = utilisateurOpt.get();
            if (utilisateur.getPassword().equals(password)) {
                return new UtilisateurDTO(utilisateur); // Renvoie un DTO à la place de l'entité
            }
        }
        return null; // Retourne null si l'utilisateur n'est pas trouvé ou si le mot de passe est incorrect
    }


    public Utilisateur findByName(String name) {
        return utilisateurRepository.findByNom(name);  // Assuming you have a 'nom' field in your 'Utilisateur' entity
    }

}
