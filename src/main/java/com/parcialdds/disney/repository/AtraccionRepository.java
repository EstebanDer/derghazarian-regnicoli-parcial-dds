package com.parcialdds.disney.repository;

import com.parcialdds.disney.entity.personaje.Atraccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtraccionRepository extends JpaRepository<Atraccion, Long> {
}
