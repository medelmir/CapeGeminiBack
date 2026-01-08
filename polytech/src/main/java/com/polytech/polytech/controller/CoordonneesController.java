package com.polytech.polytech.controller;

import com.polytech.polytech.dto.CoordonneesRequestDto;
import com.polytech.polytech.dto.CoordonneesResponseDto;
import com.polytech.polytech.service.CoordonneesService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coordonnees")
public class CoordonneesController {

    private final CoordonneesService coordonneesService;

    @Autowired
    public CoordonneesController(CoordonneesService coordonneesService) {
        this.coordonneesService = coordonneesService;
    }

    @GetMapping
    public ResponseEntity<List<CoordonneesResponseDto>> getAllCoordonnees() {
        List<CoordonneesResponseDto> coordonnees = coordonneesService.getAllCoordonnees();
        return ResponseEntity.ok(coordonnees);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CoordonneesResponseDto> getCoordonneesById(@PathVariable Long id) {
        CoordonneesResponseDto coord = coordonneesService.getCoordonneesParId(id);
        return ResponseEntity.ok(coord);
    }

    @PostMapping
    public ResponseEntity<CoordonneesResponseDto> createCoordonnees(
            @Valid @RequestBody CoordonneesRequestDto requestDto) {
        CoordonneesResponseDto savedCoord = coordonneesService.createCoordonnees(requestDto);
        return ResponseEntity.ok(savedCoord);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CoordonneesResponseDto> updateCoordonnees(
            @PathVariable Long id,
            @Valid @RequestBody CoordonneesRequestDto requestDto) {
        CoordonneesResponseDto updatedCoord = coordonneesService.updateCoordonnees(id, requestDto);
        return ResponseEntity.ok(updatedCoord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoordonnees(@PathVariable Long id) {
        coordonneesService.deleteCoordonnees(id);
        return ResponseEntity.noContent().build();
    }
}
