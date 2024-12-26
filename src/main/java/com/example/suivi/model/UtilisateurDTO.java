package com.example.suivi.model;

import java.util.List;
import java.util.stream.Collectors;
public class UtilisateurDTO {
    private int id;
    private String nom;
    private String email;
    private String gsm;
    private String type;
    private String password;
    private List<Integer> projetsProposesIds;   // IDs of proposed projects// IDs of tasks assigned

    // Default constructor (needed for deserialization)
    public UtilisateurDTO() {}

    // Constructor to map an `Utilisateur` entity to this DTO
    public UtilisateurDTO(Utilisateur utilisateur) {
        this.id = utilisateur.getId();
        this.nom = utilisateur.getNom();
        this.email = utilisateur.getEmail();
        this.gsm = utilisateur.getGsm();
        this.type = utilisateur.getType();
        this.password = utilisateur.getPassword();

        // Map associated projects and tasks to their IDs
        this.projetsProposesIds = utilisateur.getProjetsProposes() != null
                ? utilisateur.getProjetsProposes().stream().map(Projet::getId).collect(Collectors.toList())
                : null;

    }

    // Getters and setters (or use Lombok @Data for brevity)
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getGsm() {
        return gsm;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getProjetsProposesIds() {
        return projetsProposesIds;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
