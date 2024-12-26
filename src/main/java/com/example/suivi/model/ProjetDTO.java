package com.example.suivi.model;

import java.util.Date;

public class ProjetDTO {
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private String etat;
    private String titre;
    private Double budget;
    private Boolean approved;
    private String approuveParNom;
    private String proposeParNom;// Nom de l'utilisateur approuvePar

    // Constructeurs, getters et setters
    public ProjetDTO(Projet projet) {
        this.id = projet.getId();
        this.dateDebut = projet.getDateDebut();
        this.dateFin = projet.getDateFin();
        this.etat = projet.getEtat();
        this.titre = projet.getTitre();
        this.budget = projet.getBudget();
        this.approved = projet.isApproved();
        this.proposeParNom = projet.getProposePar() != null ? projet.getProposePar().getNom() : null;
    }

    public ProjetDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public String getApprouveParNom() {
        return approuveParNom;
    }

    public void setApprouveParNom(String approuveParNom) {
        this.approuveParNom = approuveParNom;
    }

    public String getProposeParNom() {
        return proposeParNom;
    }

    public void setProposeParNom(String proposeParNom) {
        this.proposeParNom = proposeParNom;
    }
}
