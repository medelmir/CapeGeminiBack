package com.polytech.polytech.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "utilisateur")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false, unique = true)
    private String mail;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;




    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Reservation> reservations;


    public void setemail(String mail) {
        this.mail = mail;
    }

    public String getEmail() {
        return mail;
    }
}

