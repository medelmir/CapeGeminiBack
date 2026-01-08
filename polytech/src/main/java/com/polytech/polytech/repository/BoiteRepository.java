package com.polytech.polytech.repository;

import com.polytech.polytech.entity.Boite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoiteRepository extends JpaRepository<Boite,Long> {
}
