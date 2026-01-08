package com.polytech.polytech.repository;

import com.polytech.polytech.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Utilisateursrepository extends JpaRepository<Utilisateur, Long> {
    boolean existsById(Long id);
}