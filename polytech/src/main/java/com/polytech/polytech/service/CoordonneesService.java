package com.polytech.polytech.service;

import com.polytech.polytech.dto.CoordonneesRequestDto;
import com.polytech.polytech.dto.CoordonneesResponseDto;
import com.polytech.polytech.entity.Boite;
import com.polytech.polytech.entity.Coordonnees;
import com.polytech.polytech.exception.BoiteInexistanteException;
import com.polytech.polytech.exception.CoordonneesInexistantesException;
import com.polytech.polytech.mapper.CoordonneesMapper;
import com.polytech.polytech.repository.BoiteRepository;
import com.polytech.polytech.repository.CoordonneesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoordonneesService {

    private final CoordonneesRepository coordonneesRepo;
    private final BoiteRepository boiteRepo;

    public CoordonneesService(CoordonneesRepository coordonneesRepo, BoiteRepository boiteRepo) {
        this.coordonneesRepo = coordonneesRepo;
        this.boiteRepo = boiteRepo;
    }

    public CoordonneesResponseDto getCoordonneesParId(Long id) {
        Coordonnees coord = coordonneesRepo.findById(id)
                .orElseThrow(() -> new CoordonneesInexistantesException("Coordonnées inexistantes : " + id));
        return CoordonneesMapper.toDTO(coord);
    }

    public List<CoordonneesResponseDto> getAllCoordonnees() {
        return coordonneesRepo.findAll()
                .stream()
                .map(CoordonneesMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CoordonneesResponseDto createCoordonnees(CoordonneesRequestDto requestDto) {
        Boite boite = boiteRepo.findById(requestDto.getBoiteId())
                .orElseThrow(() -> new BoiteInexistanteException("Boite inexistante : " + requestDto.getBoiteId()));

        Coordonnees coord = CoordonneesMapper.toEntity(requestDto);
        if (coord.getBoites() == null) {
            coord.setBoites(new ArrayList<>());
        }

        coord.getBoites().add(boite);

        boite.setCoordonnees(coord);

        Coordonnees saved = coordonneesRepo.save(coord);
        return CoordonneesMapper.toDTO(saved);
    }

    public CoordonneesResponseDto updateCoordonnees(Long id, CoordonneesRequestDto requestDto) {
        Coordonnees coord = coordonneesRepo.findById(id)
                .orElseThrow(() -> new CoordonneesInexistantesException("Coordonnées inexistantes : " + id));

        Boite boite = boiteRepo.findById(requestDto.getBoiteId())
                .orElseThrow(() -> new BoiteInexistanteException("Boite inexistante : " + requestDto.getBoiteId()));

        coord.setLatitude(requestDto.getLatitude());
        coord.setLongitude(requestDto.getLongitude());
        if (coord.getBoites() == null) {
            coord.setBoites(new ArrayList<>());
        }

        coord.getBoites().add(boite);

        boite.setCoordonnees(coord);

        Coordonnees updated = coordonneesRepo.save(coord);
        return CoordonneesMapper.toDTO(updated);
    }

    public void deleteCoordonnees(Long id) {
        Coordonnees coord = coordonneesRepo.findById(id)
                .orElseThrow(() -> new CoordonneesInexistantesException("Coordonnées inexistantes : " + id));
        coordonneesRepo.delete(coord);
    }
}
