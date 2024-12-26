package com.example.suivi.controller;

import com.example.suivi.model.Projet;
import com.example.suivi.model.ProjetDTO;
import com.example.suivi.model.UtilisateurDTO;
import com.example.suivi.service.ProjetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projects")
public class ProjetController {

    private final ProjetService projetService;

    public ProjetController(ProjetService projetService) {
        this.projetService = projetService;
    }

    @GetMapping("/list")
    public List<ProjetDTO> getProjects() {
        return projetService.getAllProjects().stream()
                .map(ProjetDTO::new)
                .collect(Collectors.toList());
    }


    @PutMapping("/{id}/approve")
    public ResponseEntity<Projet> approveProject(@PathVariable int id) {
        Projet approvedProject = projetService.approveProject(id);
        return ResponseEntity.ok(approvedProject);
    }
    @PutMapping("/{id}/disapprove")
    public ResponseEntity<Projet> disApproveProject(@PathVariable int id) {
        Projet approvedProject = projetService.disApproveProject(id);
        return ResponseEntity.ok(approvedProject);
    }

    @PostMapping("/add")
    public String addProject(@RequestBody ProjetDTO projetDTO) {
        try {
            projetService.addProject(projetDTO);
            return "Project added successfully.";
        } catch (Exception e) {
            return"Error adding user.";
        }
    }
}
