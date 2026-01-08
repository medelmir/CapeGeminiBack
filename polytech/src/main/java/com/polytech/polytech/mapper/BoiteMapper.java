package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.BoiteRequestDto;
import com.polytech.polytech.dto.BoiteResponseDto;
import com.polytech.polytech.entity.Boite;
import org.springframework.stereotype.Component;


import com.polytech.polytech.dto.BoiteRequestDto;
import com.polytech.polytech.dto.BoiteResponseDto;
import com.polytech.polytech.entity.Boite;

public class BoiteMapper {

    public static Boite toEntity(BoiteRequestDto dto) {
        Boite boite = new Boite();
        boite.setNom(dto.getNom());
        boite.setQuantite(dto.getQuantite());
        boite.setDescription(dto.getDescription());
        return boite;
    }

    public static BoiteResponseDto toDTO(Boite boite) {
        BoiteResponseDto dto = new BoiteResponseDto();
        dto.setIdentifiant(boite.getIdentifiant());
        dto.setNom(boite.getNom());
        dto.setQuantite(boite.getQuantite());
        dto.setDescription(boite.getDescription());

        if (boite.getCoordonnees() != null) {
            dto.setLatitude(boite.getCoordonnees().getLatitude());
            dto.setLongitude(boite.getCoordonnees().getLongitude());
        }

        return dto;
    }
}