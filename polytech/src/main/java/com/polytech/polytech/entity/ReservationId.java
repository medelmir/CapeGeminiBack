package com.polytech.polytech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationId implements Serializable {

    @Column(name = "utilisateur_id", nullable = false)
    private Long utilisateurId;

    @Column(name = "boite_id", nullable = false)
    private Long boiteId;

}
