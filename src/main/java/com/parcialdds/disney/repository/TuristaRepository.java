package com.parcialdds.disney.repository;

import com.parcialdds.disney.entity.producto.Turista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TuristaRepository extends JpaRepository<Turista, Long> {
}
