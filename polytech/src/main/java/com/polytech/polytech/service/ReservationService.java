package com.polytech.polytech.service;

import com.polytech.polytech.dto.ReservationRequestDto;
import com.polytech.polytech.dto.ReservationResponseDto;
import com.polytech.polytech.entity.Boite;
import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.entity.ReservationId;
import com.polytech.polytech.entity.Utilisateur;
import com.polytech.polytech.exception.BoiteInexistanteException;
import com.polytech.polytech.exception.ReservationInexistanteException;
import com.polytech.polytech.exception.UtilisateurInexistantException;
import com.polytech.polytech.mapper.ReservationMapper;
import com.polytech.polytech.repository.BoiteRepository;
import com.polytech.polytech.repository.ReservationRepository;
import com.polytech.polytech.repository.Utilisateursrepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {

    public ReservationRepository reservationRepository;
    public Utilisateursrepository utilisateursrepository;
    public BoiteRepository boiteRepository;

    public ReservationService(ReservationRepository repo1, Utilisateursrepository repo2, BoiteRepository repo3) {
        this.reservationRepository = repo1;
        this.utilisateursrepository = repo2;
        this.boiteRepository = repo3;
    }

    public List<ReservationResponseDto> getallReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationResponseDto> response = reservations.stream().map(ReservationMapper::toDTO)
                .collect(Collectors.toList());
        return response;
    }

    public ReservationResponseDto createReservation(ReservationRequestDto reservationRequestDto) {
        Utilisateur utilisateur = utilisateursrepository.findById(reservationRequestDto.getUtilisateurId())
                .orElseThrow(() -> new UtilisateurInexistantException("Utilisateur inexistant"));
        Boite boite = boiteRepository.findById(reservationRequestDto.getBoiteId())
                .orElseThrow(() -> new BoiteInexistanteException("Boite inexistante"));
        Reservation notre_reservation = ReservationMapper.toEntity(reservationRequestDto, utilisateur, boite);
        reservationRepository.save(notre_reservation);
        return ReservationMapper.toDTO(notre_reservation);
    }

    public ReservationResponseDto updateReservation(Long utilisateurId, Long boiteId,
                                                    ReservationRequestDto reservationRequestDto) {

        ReservationId reservationId = new ReservationId(utilisateurId, boiteId);


        Reservation existingReservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ReservationInexistanteException("Reservation inexistante"));


        if (reservationRequestDto.getReservation() != null) {
            existingReservation.setReservation(reservationRequestDto.getReservation());
        }


        reservationRepository.save(existingReservation);
        return ReservationMapper.toDTO(existingReservation);
    }

    public void deleteReservation(Long utilisateurId, Long boiteId) {

        ReservationId reservationId = new ReservationId(utilisateurId, boiteId);


        if (!reservationRepository.existsById(reservationId)) {
            throw new ReservationInexistanteException("Reservation inexistante");
        }


        reservationRepository.deleteById(reservationId);
    }

}

