package com.polytech.polytech.mapper;

import com.polytech.polytech.dto.ReservationRequestDto;
import com.polytech.polytech.dto.ReservationResponseDto;
import com.polytech.polytech.entity.Boite;
import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.entity.ReservationId;
import com.polytech.polytech.entity.Utilisateur;

public class ReservationMapper {
    public static Reservation toEntity(ReservationRequestDto dto, Utilisateur utilisateur, Boite boite) {
        Reservation reservation = new Reservation();
        reservation.setId(new ReservationId(dto.getUtilisateurId(), dto.getBoiteId()));
        reservation.setUtilisateur(utilisateur);
        reservation.setBoite(boite);
        reservation.setReservation(dto.getReservation() != null ? dto.getReservation() : 1);
        return reservation;
    }

    public static ReservationResponseDto toDTO(Reservation reservation) {
        ReservationResponseDto dto = new ReservationResponseDto();
        dto.setUtilisateurId(reservation.getUtilisateur().getId());
        dto.setBoiteId(reservation.getBoite().getId());
        dto.setReservation(reservation.getReservation());
        return dto;
    }

}


