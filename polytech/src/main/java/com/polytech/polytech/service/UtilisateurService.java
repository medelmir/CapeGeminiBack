package com.polytech.polytech.service;

import com.polytech.polytech.dto.UtilisateursRequestDto;
import com.polytech.polytech.dto.UtilisateursResponseDto;
import com.polytech.polytech.entity.Boite;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.exception.BoiteInexistanteException;
import com.polytech.polytech.exception.UtilisateurInexistantException;
import com.polytech.polytech.mapper.Utilisateursmapper;
import com.polytech.polytech.repository.Utilisateursrepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService {
    public Utilisateursrepository repo;

    public UtilisateurService(Utilisateursrepository repo) {
        this.repo = repo;
    }

    public UtilisateursResponseDto getutilisateurparId(Long id) {
        if (!repo.existsById(id)) {
            throw new UtilisateurInexistantException("Utilisateur inexistant dans le system" + id);
        }
        Utilisateur user = repo.findById(id).get();
        UtilisateursResponseDto myuser = Utilisateursmapper.toDTO(user);
        return myuser;
    }

    public List<UtilisateursResponseDto> getallutilisateurs() {
        List<Utilisateur> utilisateurs = repo.findAll();
        List<UtilisateursResponseDto> utilisateursResponseDtos = utilisateurs.stream().map(Utilisateursmapper::toDTO)
                .collect(Collectors.toList());
        return utilisateursResponseDtos;
    }

    public UtilisateursResponseDto createuser(UtilisateursRequestDto utilisateursRequestDto) {
        Utilisateur user = Utilisateursmapper.toEntity(utilisateursRequestDto);
        Utilisateur utilisateur = repo.save(user);
        return Utilisateursmapper.toDTO(utilisateur);
    }

    public UtilisateursResponseDto updateuser(Long id, UtilisateursRequestDto utilisateursRequestDto) {

        Utilisateur user = repo.findById(id)
                .orElseThrow(() -> new UtilisateurInexistantException("Utilisateur inexistant"));
        user.setNom(utilisateursRequestDto.getNom());
        user.setPrenom(utilisateursRequestDto.getPrenom());
        user.setMail(utilisateursRequestDto.getMail());
        user.setUsername(utilisateursRequestDto.getUsername());
        user.setPassword(utilisateursRequestDto.getPassword());

        return Utilisateursmapper.toDTO(repo.save(user));

    }

    public void deleteUtilisateur(Long id) {
        Utilisateur user = repo.findById(id)
                .orElseThrow(() -> new UtilisateurInexistantException("Utilisateur inexistante : " + id));
        repo.delete(user);
    }
}
