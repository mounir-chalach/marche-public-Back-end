package com.example.suivi.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Projet{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date dateDebut;
    private Date dateFin;
    private String etat;
    private String titre;
    private Double budget;
    private Boolean approved;

    @ManyToOne
    @JoinColumn(name = "propose_par_id")
    private Utilisateur proposePar;



    public Projet(int id, Date dateDebut, Date dateFin, String etat, String titre, Double budget, Utilisateur proposePar, Utilisateur approuvePar) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.etat = etat;
        this.titre = titre;
        this.budget = budget;
        this.proposePar = proposePar;
    }

    public Projet(){
    }

    public Boolean isApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
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

    public Utilisateur getProposePar() {
        return proposePar;
    }

    public void setProposePar(Utilisateur proposePar) {
        this.proposePar = proposePar;
    }


    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", etat='" + etat + '\'' +
                ", titre='" + titre + '\'' +
                ", budget=" + budget +
                ", approved=" + approved +
                ", proposePar=" + proposePar +
                '}';
    }
}
