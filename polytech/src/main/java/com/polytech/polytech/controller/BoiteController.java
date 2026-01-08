package com.polytech.polytech.controller;

import com.polytech.polytech.dto.BoiteRequestDto;
import com.polytech.polytech.dto.BoiteResponseDto;
import com.polytech.polytech.service.BoiteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boites")
public class BoiteController {

    private final BoiteService boiteService;

    @Autowired
    public BoiteController(BoiteService boiteService) {
        this.boiteService = boiteService;
    }

    @GetMapping
    public ResponseEntity<List<BoiteResponseDto>> getAllBoites() {
        List<BoiteResponseDto> boites = boiteService.getAllBoites();
        return ResponseEntity.ok(boites);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoiteResponseDto> getBoiteById(@PathVariable Long id) {
        BoiteResponseDto boite = boiteService.getBoiteParId(id);
        return ResponseEntity.ok(boite);
    }

    @PostMapping
    public ResponseEntity<BoiteResponseDto> createBoite(@RequestBody BoiteRequestDto boiteRequestDto) {
        BoiteResponseDto savedBoite = boiteService.createBoite(boiteRequestDto);
        return ResponseEntity.ok(savedBoite);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoiteResponseDto> updateBoite(@PathVariable Long id,
                                                        @Valid @RequestBody BoiteRequestDto boiteRequestDto) {
        BoiteResponseDto updatedBoite = boiteService.updateBoite(id, boiteRequestDto);
        return ResponseEntity.ok(updatedBoite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoite(@PathVariable Long id) {
        boiteService.deleteBoite(id);
        return ResponseEntity.noContent().build();
    }
}
