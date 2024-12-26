package com.example.suivi.controller;

import com.example.suivi.model.Cps;
import com.example.suivi.model.CpsDTO;
import com.example.suivi.model.ProjetDTO;
import com.example.suivi.model.UtilisateurDTO;
import com.example.suivi.service.CpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cps")
public class CpsController {

    @Autowired
    private CpsService cpsService;

    @GetMapping("/list/{userId}")
    public List<CpsDTO> getCpsByUser(@PathVariable("userId") int userId) {
        // Fetch the CPS data for the specific user
        List<Cps> cpsList = cpsService.getCpsByUserId(userId);

        // Convert CPS entities to DTOs and return
        return cpsList.stream()
                .map(cps -> new CpsDTO(cps))  // Assuming you have a constructor in CpsDTO to convert Cps entity
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public String addCPS(@RequestBody CpsDTO cpsDTO) {
        try {
            cpsService.addCps(cpsDTO);
            return "Project added successfully.";
        } catch (Exception e) {
            return"Error adding user.";
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        try {
            cpsService.deleteCPSById(id);
            return ResponseEntity.ok("CPS with ID " + id + " deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user.");
        }
    }

}
