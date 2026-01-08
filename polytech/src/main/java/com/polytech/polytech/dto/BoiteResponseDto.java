package com.polytech.polytech.dto;

import com.polytech.polytech.entity.Coordonnees;

import lombok.Data;

@Data

public class BoiteResponseDto {
    // Getters and setters
    private Long identifiant;
    private String nom;
    private Integer quantite;
    private String description;
    private String latitude;
    private String longitude;

}

