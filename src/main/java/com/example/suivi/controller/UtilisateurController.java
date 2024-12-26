package com.example.suivi.controller;

import com.example.suivi.model.Projet;
import com.example.suivi.model.ProjetDTO;
import com.example.suivi.model.Utilisateur;
import com.example.suivi.model.UtilisateurDTO;
import com.example.suivi.service.ProjetService;
import com.example.suivi.service.UtilisateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/users")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/list")
    public List<UtilisateurDTO> getUsers() {
        return utilisateurService.getAllUsers().stream()
                .map(UtilisateurDTO::new)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        try {
            utilisateurService.deleteUserById(id);
            return ResponseEntity.ok("User with ID " + id + " deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user.");
        }
    }

    @PostMapping("/add")
    public String addUser(@RequestBody UtilisateurDTO utilisateurDTO) {
        try {
            utilisateurService.addUser(utilisateurDTO);
            return "User added successfully.";
        } catch (Exception e) {
            return"Error adding user.";
        }
    }


}
