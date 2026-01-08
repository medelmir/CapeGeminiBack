package com.polytech.polytech.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "reservation")
@Data
public class Reservation {

    @EmbeddedId
    private ReservationId id;

    @ManyToOne
    @MapsId("utilisateurId")
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @MapsId("boiteId")
    @JoinColumn(name = "boite_id", nullable = false)
    private Boite boite;

    @Column(nullable = false)
    private Integer reservation;
}
