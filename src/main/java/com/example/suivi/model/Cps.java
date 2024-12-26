package com.example.suivi.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Cps{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String tasks;
    private String stack;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_id")
    private Projet project_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "propose_par_id")
    private Utilisateur proposePar;

    public Cps() {
    }

    public Cps(int id,String stack, String nom, String tasks, Projet project_id, Utilisateur utilisateur_id) {
        this.id = id;
        this.nom = nom;
        this.tasks = tasks;
        this.project_id = project_id;
        this.proposePar = utilisateur_id;
        this.stack = stack;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTasks() {
        return tasks;
    }

    public void setTasks(String tasks) {
        this.tasks = tasks;
    }

    public Projet getProject_id() {
        return project_id;
    }

    public void setProject_id(Projet project_id) {
        this.project_id = project_id;
    }

    public Utilisateur getproposePar() {
        return proposePar;
    }

    public void setproposePar(Utilisateur utilisateur_id) {
        this.proposePar = utilisateur_id;
    }

    @Override
    public String toString() {
        return "Cps{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", tasks='" + tasks + '\'' +
                ", project_id=" + project_id +
                ", utilisateur_id=" + proposePar +
                '}';
    }
}
