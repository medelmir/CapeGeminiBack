package com.polytech.polytech.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Entity
@Table(name = "boite")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Boite {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long identifiant;

    @Column(nullable = false)
    private Integer quantite;
    @Column(name = "description")
    private String description;
    @Column(nullable = false)
    private String nom;


    @ManyToOne
    @JoinColumn(name = "coordonnees_id", nullable = false)
    @JsonManagedReference
    private Coordonnees coordonnees;


    public Long getId() {
        return identifiant;
    }
}