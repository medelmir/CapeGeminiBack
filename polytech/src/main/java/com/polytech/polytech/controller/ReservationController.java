package com.polytech.polytech.controller;


import com.polytech.polytech.dto.ReservationRequestDto;
import com.polytech.polytech.dto.ReservationResponseDto;
import com.polytech.polytech.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ReservationResponseDto> getAllReservations() {
        return reservationService.getallReservations();
    }

    @PostMapping
    public ReservationResponseDto createReservation(@RequestBody ReservationRequestDto dto) {
        return reservationService.createReservation(dto);
    }

    @PutMapping("/{utilisateurId}/{boiteId}")
    public ReservationResponseDto updateReservation(
            @PathVariable Long utilisateurId,
            @PathVariable Long boiteId,
            @RequestBody ReservationRequestDto dto) {
        return reservationService.updateReservation(utilisateurId, boiteId, dto);
    }

    @DeleteMapping("/{utilisateurId}/{boiteId}")
    public ResponseEntity<Void> deleteReservation(
            @PathVariable Long utilisateurId,
            @PathVariable Long boiteId) {
        reservationService.deleteReservation(utilisateurId, boiteId);
        return ResponseEntity.noContent().build();
    }

}


