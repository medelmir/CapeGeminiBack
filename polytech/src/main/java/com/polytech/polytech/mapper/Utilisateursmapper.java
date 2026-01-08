package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.UtilisateursRequestDto;
import com.polytech.polytech.dto.UtilisateursResponseDto;
import com.polytech.polytech.entity.Utilisateur;
import org.springframework.stereotype.Component;

@Component
public class Utilisateursmapper {

    // Entite -> DTO
    public static UtilisateursResponseDto toDTO(Utilisateur entite) {
        UtilisateursResponseDto dto = new UtilisateursResponseDto();
        dto.setId(entite.getId());
        dto.setNom(entite.getNom());
        dto.setPrenom(entite.getPrenom());
        dto.setMail(entite.getEmail());
        dto.setUsername(entite.getUsername());

        return dto;
    }

    // DTO -> Entite
    public static Utilisateur toEntity(UtilisateursRequestDto dto) {


        Utilisateur entite = new Utilisateur();
        entite.setNom(dto.getNom());
        entite.setPrenom(dto.getPrenom());
        entite.setemail(dto.getMail());
        entite.setUsername(dto.getUsername());
        entite.setPassword(dto.getPassword());

        return entite;
    }
}
