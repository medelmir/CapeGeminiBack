package com.polytech.polytech.service;

import com.polytech.polytech.dto.BoiteRequestDto;
import com.polytech.polytech.dto.BoiteResponseDto;
import com.polytech.polytech.entity.Boite;
import com.polytech.polytech.mapper.BoiteMapper;
import com.polytech.polytech.repository.BoiteRepository;
import com.polytech.polytech.exception.BoiteInexistanteException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import com.polytech.polytech.entity.Coordonnees;

import com.polytech.polytech.exception.CoordonneesInexistantesException;
import com.polytech.polytech.repository.CoordonneesRepository;

@Service
public class BoiteService {
    private final CoordonneesRepository coordonneesRepo;
    private final BoiteRepository boiteRepo;

    public BoiteService(BoiteRepository boiteRepo, CoordonneesRepository coordonneesRepo) {
        this.coordonneesRepo = coordonneesRepo;
        this.boiteRepo = boiteRepo;
    }

    public BoiteResponseDto createBoite(BoiteRequestDto boiteRequestDto) {
        // First, create and save the Coordonnees
        Coordonnees coordonnees = new Coordonnees();
        coordonnees.setLatitude(boiteRequestDto.getLatitude());
        coordonnees.setLongitude(boiteRequestDto.getLongitude());
        Coordonnees savedCoordonnees = coordonneesRepo.save(coordonnees);

        // Then create the Boite with the saved Coordonnees
        Boite boite = BoiteMapper.toEntity(boiteRequestDto);
        boite.setCoordonnees(savedCoordonnees);

        Boite savedBoite = boiteRepo.save(boite);
        return BoiteMapper.toDTO(savedBoite);
    }

    public void deleteBoite(Long id) {
        Boite boite = boiteRepo.findById(id)
                .orElseThrow(() -> new BoiteInexistanteException("Boite inexistante : " + id));
        boiteRepo.delete(boite);
    }

    public List<BoiteResponseDto> getAllBoites() {
        List<Boite> boites = boiteRepo.findAll();
        return boites.stream()
                .map(BoiteMapper::toDTO)
                .collect(Collectors.toList());

    }

    public BoiteResponseDto getBoiteParId(Long id) {
        Boite boite = boiteRepo.findById(id)
                .orElseThrow(() -> new BoiteInexistanteException("Boite inexistante : " + id));
        return BoiteMapper.toDTO(boite);
    }

    public BoiteResponseDto updateBoite(Long id, @Valid BoiteRequestDto boiteRequestDto) {
        Boite boite = boiteRepo.findById(id)
                .orElseThrow(() -> new BoiteInexistanteException("Boite inexistante : " + id));

        Coordonnees coordonnees = coordonneesRepo.findById(boite.getCoordonnees().getIdentifiant())
                .orElseThrow(() -> new CoordonneesInexistantesException("Coordonnees inexistantes : "
                        + boite.getCoordonnees().getIdentifiant()));

        boite.setNom(boiteRequestDto.getNom());
        boite.setQuantite(boiteRequestDto.getQuantite());
        boite.setDescription(boiteRequestDto.getDescription());

        coordonnees.setLatitude(boiteRequestDto.getLatitude());
        coordonnees.setLongitude(boiteRequestDto.getLongitude());

        Boite updatedBoite = boiteRepo.save(boite);
        return BoiteMapper.toDTO(updatedBoite);
    }
}
