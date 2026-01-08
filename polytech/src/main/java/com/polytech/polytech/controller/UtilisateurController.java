package com.polytech.polytech.controller;

import com.polytech.polytech.dto.UtilisateursRequestDto;
import com.polytech.polytech.dto.UtilisateursResponseDto;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.mapper.Utilisateursmapper;
import com.polytech.polytech.service.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {
    public UtilisateurService utilisateurService;
    @Autowired
    public UtilisateurController(UtilisateurService utilisateurServic) {
        this.utilisateurService = utilisateurServic;
    }
    @GetMapping("/{id}")
    public ResponseEntity<UtilisateursResponseDto> getutilisateur(@PathVariable Long id){

        UtilisateursResponseDto myuser= utilisateurService.getutilisateurparId(id);
        return ResponseEntity.ok(myuser);
    }
    @GetMapping
    public ResponseEntity<List<UtilisateursResponseDto>> getutilisateurs(){
        List<UtilisateursResponseDto> utilisateurs =  utilisateurService.getallutilisateurs();
        return ResponseEntity.ok(utilisateurs);
    }
    @PostMapping
    public ResponseEntity<UtilisateursResponseDto> createutilisateur(@Valid @RequestBody UtilisateursRequestDto utilisateursRequestDto){

        UtilisateursResponseDto user = utilisateurService.createuser(utilisateursRequestDto);
        return ResponseEntity.ok(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<UtilisateursResponseDto> modifierutilisateur(@PathVariable Long id , @Valid @RequestBody UtilisateursRequestDto requestDto){
        UtilisateursResponseDto user = utilisateurService.updateuser(id, requestDto);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable Long id) {
        utilisateurService.deleteUtilisateur(id);
        return ResponseEntity.noContent().build();
    }

}

