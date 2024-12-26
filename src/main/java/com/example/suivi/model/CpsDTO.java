package com.example.suivi.model;

import java.util.Date;

public class CpsDTO {
    private int id;
    private String nom;
    private String tasks;
    private String projectTitle; // Title of the associated project
    private String proposeParName; // Name of the user who proposed
    private Date startDate; // Start date of the associated project
    private Date endDate;
    private Double budget;
    private String stack;
    private int projectId; // ID of the associated project
    private int proposeParId; // ID of the user who proposed

    // Add getters and setters for these fields
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getProposeParId() {
        return proposeParId;
    }

    public void setProposeParId(int proposeParId) {
        this.proposeParId = proposeParId;
    }
    // Constructors
    public CpsDTO(int id,String stack, Double budget, String nom, String tasks, String projectTitle, String proposeParName, Date startDate, Date endDate) {
        this.id = id;
        this.nom = nom;
        this.tasks = tasks;
        this.projectTitle = projectTitle;
        this.proposeParName = proposeParName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget=budget;
        this.stack=stack;
    }

    public CpsDTO() {
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }

    // Constructor that converts a Cps entity to a DTO
    public CpsDTO(Cps cps) {
        this.id = cps.getId();
        this.nom = cps.getNom();
        this.tasks = cps.getTasks();
        this.projectTitle = cps.getProject_id() != null ? cps.getProject_id().getTitre() : null;
        this.proposeParName = cps.getproposePar() != null ? cps.getproposePar().getNom() : null;
        this.startDate = cps.getProject_id() != null ? cps.getProject_id().getDateDebut() : null;
        this.endDate = cps.getProject_id() != null ? cps.getProject_id().getDateFin() : null;
        this.budget = cps.getProject_id() != null ? cps.getProject_id().getBudget() : null;
        this.stack = cps.getStack();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProposeParName() {
        return proposeParName;
    }

    public void setProposeParName(String proposeParName) {
        this.proposeParName = proposeParName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "CpsDTO{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", tasks='" + tasks + '\'' +
                ", projectTitle='" + projectTitle + '\'' +
                ", proposeParName='" + proposeParName + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
