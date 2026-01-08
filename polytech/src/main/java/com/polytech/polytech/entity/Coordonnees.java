package com.polytech.polytech.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "coordonnees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordonnees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String latitude;

    @Column(nullable = false, length = 100)
    private String longitude;

    @OneToMany(mappedBy = "coordonnees")
    @JsonBackReference
    private List<Boite> boites;



    public Long getIdentifiant() {
        return id;
    }


}
