package com.polytech.polytech.repository;

import com.polytech.polytech.entity.Coordonnees;
import com.polytech.polytech.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface CoordonneesRepository extends JpaRepository<Coordonnees, Long> {
    Optional<Coordonnees> findByBoites_Id(Long boiteId);
}
