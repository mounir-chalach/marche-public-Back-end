package com.example.suivi.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String email;
    private String password;
    private String gsm;
    private String type;

    @OneToMany(mappedBy = "proposePar", fetch = FetchType.EAGER)
    private List<Projet> projetsProposes;


    @OneToMany(mappedBy = "proposePar", fetch = FetchType.EAGER)
    private List<Cps> cpsprpose;

    public Utilisateur(int id, String nom, String email, String password, String gsm, String type, List<Projet> projetsProposes, List<Cps> cpsprpose) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.gsm = gsm;
        this.type = type;
        this.projetsProposes = projetsProposes;
        this.cpsprpose = cpsprpose;
    }

    public List<Cps> getCpsprpose() {
        return cpsprpose;
    }

    public void setCpsprpose(List<Cps> cpsprpose) {
        this.cpsprpose = cpsprpose;
    }

    public Utilisateur(){}


    public List<Projet> getProjetsProposes() {
        return projetsProposes;
    }

    public void setProjetsProposes(List<Projet> projetsProposes) {
        this.projetsProposes = projetsProposes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
