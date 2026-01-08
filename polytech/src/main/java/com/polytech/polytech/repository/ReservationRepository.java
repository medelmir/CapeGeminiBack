package com.polytech.polytech.repository;

import com.polytech.polytech.entity.Reservation;
import com.polytech.polytech.entity.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, ReservationId> {

}
