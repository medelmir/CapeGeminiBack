package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.CoordonneesRequestDto;
import com.polytech.polytech.dto.CoordonneesResponseDto;
import com.polytech.polytech.entity.Boite;
import com.polytech.polytech.entity.Coordonnees;

import java.util.stream.Collectors;

public class CoordonneesMapper {

    public static Coordonnees toEntity(CoordonneesRequestDto dto) {
        Coordonnees coord = new Coordonnees();
        coord.setLatitude(dto.getLatitude());
        coord.setLongitude(dto.getLongitude());
        return coord;
    }

    public static CoordonneesResponseDto toDTO(Coordonnees coord) {
        return new CoordonneesResponseDto(
                coord.getId(),
                coord.getLatitude(),
                coord.getLongitude(),
                coord.getBoites() != null
                        ? coord.getBoites().stream()
                        .map(Boite::getId)
                        .collect(Collectors.toList())
                        : null
        );
    }
}
